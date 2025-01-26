import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.HttpTextBodyContent
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.ConditionType

/**
 * 发送HTTP请求的函数
 * @param url 请求的URL
 * @param method 请求方法 (GET, POST, PUT, DELETE)
 * @param headers 请求头，Map格式，例如: ['Content-Type':'application/json']
 * @param body 请求体，Map格式，例如: ['key':'value']
 * @return 响应文本
 */
def sendHttpRequest(String url, String method, Map<String, String> headers, Map<String, Object> body) {
    // 创建请求对象
    RequestObject request = new RequestObject()
    request.setRestUrl(url)
    request.setRestRequestMethod(method.toUpperCase())

    // 设置请求头
    List<TestObjectProperty> headerList = []
    headers.each { key, value ->
        headerList.add(new TestObjectProperty(key, ConditionType.EQUALS, value))
    }
    request.setHttpHeaderProperties(headerList)

    // 设置请求体（将 Map 转换为 JSON 格式字符串）
    if (body && (method.toUpperCase() == 'POST' || method.toUpperCase() == 'PUT')) {
        String jsonBody = new groovy.json.JsonBuilder(body).toPrettyString()
        request.setBodyContent(new HttpTextBodyContent(jsonBody, 'UTF-8', 'application/json'))
    }

    // 发送请求并获取响应
    def response = WS.sendRequest(request)

    // 输出响应信息
    println("Response Status: " + response.getStatusCode())
    println("Response Body: " + response.getResponseBodyContent())

    return response.getResponseBodyContent()
}

// 示例调用函数
def url = 'https://jsonplaceholder.typicode.com/posts'
def method = 'POST'
def headers = ['Content-Type': 'application/json']
def body = ['title': 'Groovy Request', 'body': 'This is a test request', 'userId': 1]

// 调用发送请求函数
def response = sendHttpRequest(url, method, headers, body)
println("API Response: " + response)