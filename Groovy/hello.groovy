
打印数据的基础类型

def a = 123
def b = "Hello"
def c = [1, 2, 3]
def d = 3.14
def e = true

println "a 的类型是: ${a.getClass()}"
println "b 的类型是: ${b.class}"
println "c 的类型是: ${c.getClass().name}"
println "d 的类型是: ${d.class.name}"
println "e 的类型是: ${e.getClass().simpleName}"



json Map转为String:
// Map<String, Object> newRequestBody
方法一：
String updateBodyStr = JsonOutput.toJson(newRequestBody)
方法二：
String jsonBody = new groovy.json.JsonBuilder(body).toPrettyString()



// 示例调用函数
def url = 'https://jsonplaceholder.typicode.com/posts'
def method = 'POST'
def headers = ['Content-Type': 'application/json']
def body = ['title': 'Groovy Request', 'body': 'This is a test request', 'userId': 1]

// 调用发送请求函数
def response = CustomKeywords.'common.Http.sendHttpRequest'(url, method, headers, body)
println("API Response: " + response)


void submission(TestObject request, Map headers = null, Map body = null) {
    response = WS.sendRequest(requestTestObject)

    if (response.getStatusCode() == 200) {
        def jsonSlurper = new JsonSlurper()

        def responseData = jsonSlurper.parseText(response.getResponseText())

        def applicationId = responseData.applicationId

        WebUI.comment('applicationId is: ' + applicationId)
    } else {
        WebUI.comment('Failed to get API. Status code: ' + response.getStatusCode())
    }
}



HashMap设值
-------------
1.方括号
2. .号
3. put方法

// 定义一个 Map
def map = [name: 'John', age: 30]
// 更新 age 的值
map['age'] = 31
// 输出更新后的 Map
println(map) 

def map = [city: 'New York', country: 'USA']
// 更新 city 的值
map.city = 'Los Angeles'
println(map) 

def map = [color: 'red', size: 'large']
// 更新 color 的值
map.put('color', 'blue')
println(map) 

嵌套更新
def nestedMap = [
    person: [
        name: 'Alice',
        details: [
            occupation: 'Engineer'
        ]
    ]
]
// 更新嵌套 Map 中的 occupation 值
nestedMap.person.details.occupation = 'Doctor'
println(nestedMap) 

批量更新
def map = [fruit: 'apple', price: 2.5]
def updateMap = [fruit: 'banana', quantity: 5]

// 批量更新值
map.putAll(updateMap)
println(map) 


解析json:
--------------
import groovy.json.JsonBuilder
import groovy.json.JsonOutput
import groovy.json.JsonSlurper

private static void jsonUsage(){
        def jsonStr = '[{"applicationNum":"88885377","paymentRequestType":"TOP_UP_PAYMENT","amount":"80000","requestId":"1527153099","paymentRequestCreationSource":"CASHIER","currency":"USD","items":[{"refNo":"77991","discrepancyReason":"TEST123","amount":80000,"address":"testaddress","mobileNumber":"+852AT17313076965","payerId":"2008300746","verifierName":"test_super_user@manulife.com.mm.mmqa","premiumType":"Top up","emailAddress":"uip_automation_test@manulife.com","preferredPayor":true,"registrationType":"National Id","verifier":"0051s000000hG7ZAAU","bankPartner":"HSBC","payorOcdmId":"001Au00000oEQfcIAG","sourcePolicyNum":"99987","paymentMethod":"BT","payerName":"apriltest3","currency":"USD","sourceOfPayment":"EXCHANGE","receivedDate":"2025-03-03T00:00:00+06:30"}]}]'
        def jsonSlurper = new JsonSlurper()
        // 解析String为json对象
        def list = jsonSlurper.parseText(jsonStr)
        def body = list
        if(body != null) {
            // 解析json对象为String
            println("request body: " + JsonOutput.toJson(body))
            // 解析json对象为String
            String jsonBody = new JsonBuilder(body).toPrettyString()
            println(jsonBody)
        }
    }



//获取数据类型：
// .getClass().getSimpleName()
Map a= ['FA':51857.9, 'CIA':6482.24, 'CNIA':6482.24, 'PIA':12964.47, 'NPIA':12964.47, 'PROIA':12964.48]
println(a.each { key, value ->
    println(value.getClass().getSimpleName())
})

默认的数据类型为BigDecimal，不是double

// 设置数据四舍五入

import java.math.BigDecimal as BigDecimal
import java.math.RoundingMode as RoundingMode

BigDecimal a = new BigDecimal(it['value']).setScale(2, RoundingMode.HALF_UP);


//数组取前6个
def list = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
def firstSix = list.take(6)
println(firstSix)  // 输出: [1, 2, 3, 4, 5, 6]
//数组取后6个
def lastSix = list.takeRight(6)
//取[12,18)的数据
def middleSix = list.subList(12,18)
