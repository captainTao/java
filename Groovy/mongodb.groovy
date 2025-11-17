package db
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable as GlobalVariable

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.exception.WebElementNotFoundException

import com.mongodb.ConnectionString
import com.mongodb.MongoClientSettings
import com.mongodb.client.MongoClients
import com.mongodb.client.MongoClient
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase

import com.mongodb.client.*
import com.mongodb.client.model.Filters
import com.mongodb.client.model.UpdateOptions
import com.mongodb.client.model.Updates
import java.util.concurrent.TimeUnit
import org.bson.Document
import org.bson.conversions.Bson
import org.bson.types.ObjectId
import com.mongodb.client.model.Sorts;
import java.util.regex.Pattern;
import org.bson.BsonDocument


class MongoDB {
    private static volatile MongoClient mongoClient
    private MongoDatabase database
    private MongoCollection<Document> collection

    static {
        Runtime.runtime.addShutdownHook(new Thread({ closeMongoDBConnection() }))
    }


    void connectToMongoDB(String uri = GlobalVariable.db_connnection, String databaseName = GlobalVariable.database_name, String collectionName) {
        initMongoClient(uri)
        this.database = mongoClient.getDatabase(databaseName)
        this.collection = database.getCollection(collectionName)
    }
    
    private static void initMongoClient(String uri) {
        if (!mongoClient) {
            synchronized (MongoDBHelper) {
                if (!mongoClient) {
                    def settings = MongoClientSettings.builder()
                            .applyConnectionString(new ConnectionString(uri))
                            .applyToClusterSettings { builder ->
                                builder.serverSelectionTimeout(10, TimeUnit.SECONDS)
                            }
                            .applyToSocketSettings { builder ->
                                builder.connectTimeout(10, TimeUnit.SECONDS)
                                builder.readTimeout(10, TimeUnit.SECONDS)
                            }
                            .applyToConnectionPoolSettings { builder ->
                                builder.maxSize(100)
                            }
                            .build()
                    mongoClient = MongoClients.create(settings)
                    println "MongoClient initialized."
                }
            }
        }
    }
    
    @Keyword
    def switchDatabase(String dbName) {
        this.database = mongoClient.getDatabase(dbName)
        println("Switched to database: $dbName")
    }

    @Keyword
    def switchCollection(String collectionName) {
        this.collection = database.getCollection(collectionName)
        println("Switched to collection: $collectionName")
    }

    @Keyword
    void insertOneDocument( String collectionName, Document document) {
        this.connectToMongoDB(collectionName)
        collection.insertOne(document)
    }

    @Keyword
    void insertManyDocuments(String collectionName,List<Document> documents) {
        this.connectToMongoDB(collectionName)
        collection.insertMany(documents)
    }

    @Keyword
    List<Document> findAllDocuments(String collectionName, Bson sort = Sorts.descending("_id"), int limitNo = 0) {
        this.connectToMongoDB(collectionName)
        List<Document> documents = []
        FindIterable<Document> iterable = null
        if (limitNo == 0) {
            iterable = collection.find().sort(sort)
        } else {
            iterable = collection.find().sort(sort).limit(limitNo)
        }
        for (Document document : iterable) {
            documents.add(document)
        }
        return documents
    }

    private Bson buildSmartFilter(String field, Object value) {
        if (value instanceof Pattern) {
            return Filters.regex(field, (Pattern) value);
        }
        if (value instanceof String) {
            if (value.contains("*") || value.contains("%") || value.contains("/")) {
                String regex = value.replace("*", ".*").replace("%", ".*").replace("/", ".*");
                return Filters.regex(field, regex, "i");
            }
        }
        if (value instanceof Map) {
            Map<?, ?> map = (Map<?, ?>) value;
            List<Bson> filters = new ArrayList<>();
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                String op = entry.getKey().toString();
                Object val = entry.getValue();
                switch (op) {
                    case '$gt':
                        filters.add(Filters.gt(field, val));
                        break;
                    case '$lt':
                        filters.add(Filters.lt(field, val));
                        break;
                    case '$gte':
                        filters.add(Filters.gte(field, val));
                        break;
                    case '$lte':
                        filters.add(Filters.lte(field, val));
                        break;
                    case '$ne':
                        filters.add(Filters.ne(field, val));
                        break;
                    case '$in':
                        filters.add(Filters.in(field, (List<?>) val));
                        break;
                    case '$nin':
                        filters.add(Filters.nin(field, (List<?>) val));
                        break;
                    default:
                        filters.add(Filters.eq(field, val));
                        break;
                }
            }
            return Filters.and(filters);
        }
        return Filters.eq(field, value);
    }

    @Keyword
    List<Document> findDocumentsByField(String collectionName,String field, Object value, Bson sort = Sorts.descending("_id"), int limitNo = 0) {
        this.connectToMongoDB(collectionName)
        List<Document> documents = []
        FindIterable<Document> iterable = null
        if (limitNo == 0) {
            iterable = collection.find(buildSmartFilter(field, value)).sort(sort)
        } else {
            iterable = collection.find(buildSmartFilter(field, value)).sort(sort).limit(limitNo)
        }
        for (Document document : iterable) {
            documents.add(document)
        }
        return documents
    }

    @Keyword
    List<Document> findDocumentsByMultipleFields(String collectionName, Map<String, Object> conditions, Bson sort = Sorts.descending("_id"), int limitNo = 0) {
        this.connectToMongoDB(collectionName)
        List<Document> documents = []
        Bson[] filterArray = new Bson[conditions.size()]
        int index = 0
        for (Map.Entry<String, Object> entry : conditions.entrySet()) {
            filterArray[index++] = buildSmartFilter(entry.getKey(), entry.getValue())
        }
        FindIterable<Document> iterable = null
        if (limitNo == 0) {
            iterable = collection.find(Filters.and(filterArray)).sort(sort)
        } else {
            iterable = collection.find(Filters.and(filterArray)).sort(sort).limit(limitNo)
        }
        for (Document document : iterable) {
            documents.add(document)
        }
        return documents
    }

    /**
     * refer to the method 'findDocumentsRawJson'
     * @param collectionName
     * @param filterArray
     * @return
     */
    @Keyword
    List<Document> findDocumentsRaw(String collectionName, Bson filterArray) {
        this.connectToMongoDB(collectionName)
        List<Document> documents = []
        FindIterable<Document> iterable = null
        iterable = collection.find(filterArray)
        for (Document document : iterable) {
            documents.add(document)
        }
        return documents
    }

    /**
     * find document using raw json string copied from compass client
     * @param collectionName
     * @param bsonString directly copy from compass client
     *      1. query in the compass client
     *      2. copy the json string and convert to json format, e.g.
     *          {"paymentRequestType":"TOP_UP_PAYMENT","paymentRequest.applicationItems":{ "$elemMatch":{"applicationNum":"88875255"}}}
     *          here, the $elemMatch is used to query in sub list
     * @return query documents
     */
    @Keyword
    List<Document> findDocumentsRawJson(String collectionName, String bsonString) {
        def bson = BsonDocument.parse(bsonString)
        return findDocumentsRaw(collectionName, bson)
    }

    @Keyword
    List<Document> findDocumentsByFieldWithSortAndLimit(String collectionName, Map<String, Object> conditions ,String order='', String sort='', String limit='') {
        this.connectToMongoDB(collectionName)
        List<Document> documents = []
        Bson[] filterArray = new Bson[conditions.size()]
        int index = 0
        for (Map.Entry<String, Object> entry : conditions.entrySet()) {
            filterArray[index++] = buildSmartFilter(entry.getKey(), entry.getValue())
        }
        FindIterable<Document> iterable = collection.find(Filters.and(filterArray))

        Bson orderCondition = null;
        if (!order.equals("")) {
            if (sort.equalsIgnoreCase("desc")) {
                orderCondition = Sorts.orderBy(Sorts.orderBy(Sorts.descending(order)));
            } else if (sort.equalsIgnoreCase("asc")) {
                orderCondition = Sorts.orderBy(Sorts.orderBy(Sorts.ascending(order)));
            }
            iterable = iterable.sort(orderCondition);
        }
        if (!limit.equals("")) {
            iterable = iterable.limit(Integer.parseInt(limit));
        }
        for (Document document : iterable) {
            documents.add(document)
        }
        return documents
    }

    @Keyword
    void updateOneDocument(String collectionName, String field, Object oldValue, String updateField, Object newValue, Map<String, Object> updateOptions = null) {
        this.connectToMongoDB(collectionName)
        if (updateOptions != null) {
            List<Bson> optionsList = new ArrayList<>();
            for (Map.Entry<String, Object> entry : updateOptions.entrySet()) {
                optionsList.add(buildSmartFilter(entry.getKey(), entry.getValue()));
            }
            collection.updateOne(buildSmartFilter(field, oldValue), Updates.set(updateField, newValue), new UpdateOptions().arrayFilters(optionsList))
        } else {
            collection.updateOne(buildSmartFilter(field, oldValue), Updates.set(updateField, newValue))
        }
    }

    /**
     * when update document in array, the conditions HAVE to accurately query item, and the updateFields key HAVE to contain the '$' to present the chosen item in the array
     * e.g.
     * condition=[agreementNum: _.num, agreementComponentType: 'BasePlan']
     * updateFields=['agreementComponents.$.maturityDate': matureDate]
     * @param uri
     * @param databaseName
     * @param collectionName
     * @param conditions
     * @param updateFields
     */
    @Keyword
    void updateManyDocuments(String collectionName, Map<String, Object> conditions, Map<String, Object> updateFields, Map<String, Object> updateOptions = null) {
        this.connectToMongoDB(collectionName)
        Bson[] filterArray = new Bson[conditions.size()]
        int index = 0
        for (Map.Entry<String, Object> entry : conditions.entrySet()) {
            filterArray[index++] = buildSmartFilter(entry.getKey(), entry.getValue())
        }
        Bson combinedFilter = Filters.and(filterArray)

        List<Bson> updateList = []
        for (Map.Entry<String, Object> entry : updateFields.entrySet()) {
            updateList.add(Updates.set(entry.getKey(), entry.getValue()))
        }
        Bson combinedUpdate = Updates.combine(updateList)

        if (updateOptions != null) {
            List<Bson> optionsList = new ArrayList<>();
            for (Map.Entry<String, Object> entry : updateOptions.entrySet()) {
                optionsList.add(buildSmartFilter(entry.getKey(), entry.getValue()));
            }
            collection.updateMany(combinedFilter, combinedUpdate, new UpdateOptions().arrayFilters(List.of(Filters.and(optionsList))));
        } else {
            collection.updateMany(combinedFilter, combinedUpdate);
        }
    }

    @Keyword
    void deleteOneDocument(String collectionName, String field, Object value) {
        this.connectToMongoDB(collectionName)
        collection.deleteOne(buildSmartFilter(field, value))
    }

    @Keyword
    void deleteManyDocuments(String collectionName, Map<String, Object> conditions) {
        this.connectToMongoDB(collectionName)
        Bson[] filterArray = new Bson[conditions.size()]
        int index = 0
        for (Map.Entry<String, Object> entry : conditions.entrySet()) {
            filterArray[index++] = buildSmartFilter(entry.getKey(), entry.getValue())
        }
        Bson combinedFilter = Filters.and(filterArray)
        collection.deleteMany(combinedFilter)
    }

    @Keyword
    void deleteDocumentById(String collectionName, String id) {
        this.connectToMongoDB(collectionName)
        ObjectId objectId = new ObjectId(id)
        collection.deleteOne(Filters.eq("_id", objectId))
    }

    static void closeMongoDBConnection() {
        if (mongoClient != null) {
            mongoClient.close()
            println("MongoClient closed.")
        }
    }
}