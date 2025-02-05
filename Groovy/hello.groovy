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