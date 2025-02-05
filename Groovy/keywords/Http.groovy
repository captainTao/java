package common

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.ConditionType

import groovy.json.JsonSlurper
import groovy.json.JsonOutput
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.HttpBodyContent
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import org.apache.http.client.utils.URIBuilder
import internal.GlobalVariable

public class Http {

	/**
	 * get HttpRequest body
	 * */
	@Keyword
	def String getRequestBody(TestObject requestTestObject) {
		//		return requestTestObject.getHttpBody()
		return requestTestObject.getBodyContent().getText()
	}

	/**
	 * get HttpRequest headers
	 * */
	@Keyword
	def Map getRequestHeader(TestObject requestTestObject) {
		def requestHeaders = requestTestObject.getHttpHeaderProperties()
		def headerMap = [:]
		requestHeaders.each { header ->
			headerMap[header.getName()] = header.getValue()
			println("request Header: ${header.getName()} = ${header.getValue()}")
		}
		return headerMap
	}

	/**
	 * update request Header by part HeaderMap and request
	 */
	@Keyword
	def String updateAndRequest(RequestObject request, Map headers = null, Map body = null) {
		def headerMap = null
		if (headers != null) {
			headerMap = getRequestHeader(request)
			headers.each { key, value ->
				headerMap[key] = value
			}
		}
		return sendRequest(request, headers= headerMap, body = body)
	}


	/**
	 * send HttpRequest with request Object
	 * */
	@Keyword
	def Object sendRequest(TestObject request, Map headers = null, Map body = null) {
		if(headers != null) {
			List<TestObjectProperty> headerList = []
			println("headers = $headers")
			headers.each { key, value ->
				headerList.add(new TestObjectProperty(key, ConditionType.EQUALS, value))
			}
			request.setHttpHeaderProperties(headerList)
		}
		if(body != null) {
			println("request body = $body")
			String jsonBody = new groovy.json.JsonBuilder(body).toPrettyString()
			request.setBodyContent(new HttpTextBodyContent(jsonBody, 'UTF-8', 'application/json'))
		}

		def response = WS.sendRequest(request)
		println("Response Status: " + response.getStatusCode())
		println("Response Body: " + response.getResponseBodyContent())
		return response
	}




	/**
	 * send HttpRequest with url
	 * */
	@Keyword
	def Object sendHttpRequest(String url, String method, Map<String, String> headers=null, Map<String, Object> params=null, Map<String, Object> body=null) {
		RequestObject request = new RequestObject()
		if (params != null) {
			List<String> query = []
			params.each{ key, value ->
				query.add("$key=$value")
			}
			url = url + "?" + query.join("&")
		}
		println("url = $url")
		request.setRestUrl(url)
		println("method = $method")
		request.setRestRequestMethod(method.toUpperCase())

		if (headers != null) {
			List<TestObjectProperty> headerList = []
			println("headers = $headers")
			headers.each { key, value ->
				headerList.add(new TestObjectProperty(key, ConditionType.EQUALS, value))
			}
			request.setHttpHeaderProperties(headerList)
		}

		println("request body = $body")
		if (body && (method.toUpperCase() == 'POST' || method.toUpperCase() == 'PUT')) {
			String jsonBody = new groovy.json.JsonBuilder(body).toPrettyString()
			request.setBodyContent(new HttpTextBodyContent(jsonBody, 'UTF-8', 'application/json'))
		}

		def response = WS.sendRequest(request)
		println("Response Status: " + response.getStatusCode())
		println("Response Body: " + response.getResponseBodyContent())
		return response
	}

	static void main(String[] args) {
		def url = 'https://jsonplaceholder.typicode.com/posts'
		def method = 'POST'
		def headers = ['Content-Type': 'application/json']
		def body = ['title': 'Groovy Request', 'body': 'This is a test request', 'userId': 1]
		Http http = new Http()
		def response = http.sendHttpRequest(url, method, headers, body)
		println("API Response: " + response)
	}
}
