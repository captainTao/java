
Groovy 中：null、false、0、''（空字符串）、[]（空列表）、[:]（空 Map）都被当作 “假”。


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

list
---------------------
//数组取前6个
def list = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
def firstSix = list.take(6)
println(firstSix)  // 输出: [1, 2, 3, 4, 5, 6]
//数组取后6个
def lastSix = list.takeRight(6)
//取[12,18)的数据
def middleSix = list.subList(12,18)

list.each
def list = [1, 2, 3]

// ① 使用隐式参数 it
list.each { println it }          // 输出 1 2 3

// ② 显式命名参数，带类型或不带类型都可以
list.each { item -> println item }
list.each { Integer n -> println n * 2 }



list.find { predicate }

返回：满足条件的第一个元素；如果没有匹配，返回 null。
类型：与列表元素的类型相同。


def nums = [1, 3, 5, 8]
def firstEven = nums.find { it % 2 == 0 }   // -> 8
def firstGt10 = nums.find { it > 10 }       // -> null


list.every { predicate }

返回：boolean。所有元素都满足条件时为 true；只要有一个不满足则 false。
空列表：对空列表调用 every 返回 true（“所有元素都满足”在空集上为真）。

[2, 4, 6].every { it % 2 == 0 }    // -> true
[2, 3, 6].every { it % 2 == 0 }    // -> false
[].every { it > 0 }                // -> true


list.any { predicate }

返回：boolean。只要有一个元素满足条件即为 true；一个也没有则 false。
空列表：返回 false（没有任何元素满足）。

[1, 3, 5].any { it % 2 == 0 }     // -> false
[1, 4, 5].any { it % 2 == 0 }     // -> true
[].any { it > 0 }                 // -> false


findAll { predicate }

返回：所有匹配的元素组成的 List。没有匹配则返回 空列表。

def evens = [1,2,3,4].findAll { it % 2 == 0 }  // -> [2, 4]
def none  = [1,3,5].findAll { it % 2 == 0 }    // -> []


count { predicate }

返回：满足条件的元素个数（int）
[1,2,3,4].count { it % 2 == 0 }    // -> 2


grep(patternOrPredicate)

返回：匹配模式或谓词的元素列表（List），类似于 findAll，但支持正则/类匹配
['TOPUP', 'TOPDOWN', 'PAYMENT'].grep(~/TOP.*/)   // -> ['TOPUP', 'TOPDOWN']

collect { transform }（映射）

返回：对每个元素应用变换后的新列表。

[1,2,3].collect { it * 10 }       // -> [10, 20, 30]
suspensDocs.collect { it.getString('suspenseAmount') } // -> List<String>


groupBy { keySelector }

返回：Map<K, List<V>>，按 key 分组。


def grouped = suspensDocs.groupBy { it.getString('businessEvent') }
// grouped['TOPUP'] -> List<Document>


takeWhile { predicate } / dropWhile { predicate }

返回：根据条件在序列头部截取或丢弃元素（短路，遇到不满足即停止）。

[1,2,3,1].takeWhile { it < 3 }  // -> [1,2]
[1,2,3,1].dropWhile { it < 3 }  // -> [3,1]

withDefault {}（Map 专用）

为 Map 设置缺省值生成器，避免 null 或 MissingPropertyException。

def m = [:].withDefault { 0 }
m['a']++     // -> 1

Groovy 中：null、false、0、''（空字符串）、[]（空列表）、[:]（空 Map）都被当作 “假”。
find 返回 null 时，用 if (result) 判断为 false；
findAll 返回 []，用 if (list) 判断也为 false。


类java用法：
doc.getString('suspenseUsage') == 'PAYMENT' && doc.getString('businessEvent') == 'TOPUP' 
            }).collect(Collectors.toList())[0].getString('suspenseAmount') == AmountPayment
