json Map转为String:
// Map<String, Object> newRequestBody
方法一：
String updateBodyStr = JsonOutput.toJson(newRequestBody)
方法二：
String jsonBody = new groovy.json.JsonBuilder(body).toPrettyString()



// 示例调用函数
//def url = 'https://jsonplaceholder.typicode.com/posts'
//def method = 'POST'
//def headers = ['Content-Type': 'application/json']
//def body = ['title': 'Groovy Request', 'body': 'This is a test request', 'userId': 1]
//
//// 调用发送请求函数
//def response = CustomKeywords.'common.Http.sendHttpRequest'(url, method, headers, body)
//println("API Response: " + response)