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
	 * send HttpRequest with request Object
	 * */
	def String sendRequest(TestObject request, Map headers = null, Map body = null) {
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
		return response.getResponseBodyContent()
	}


	/**
	 * update or set request Header by HashMap
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
	 * send HttpRequest with url
	 * */
	@Keyword
	def String sendHttpRequest(String url, String method, Map<String, String> headers, Map<String, Object> body) {
		RequestObject request = new RequestObject()
		println("url = $url")
		request.setRestUrl(url)
		println("method = $method")
		request.setRestRequestMethod(method.toUpperCase())

		List<TestObjectProperty> headerList = []
		println("headers = $headers")
		headers.each { key, value ->
			headerList.add(new TestObjectProperty(key, ConditionType.EQUALS, value))
		}
		request.setHttpHeaderProperties(headerList)

		println("request body = $body")
		if (body && (method.toUpperCase() == 'POST' || method.toUpperCase() == 'PUT')) {
			String jsonBody = new groovy.json.JsonBuilder(body).toPrettyString()
			request.setBodyContent(new HttpTextBodyContent(jsonBody, 'UTF-8', 'application/json'))
			//			request.setHttpBody(jsonBody)
		}

		def response = WS.sendRequest(request)
		println("Response Status: " + response.getStatusCode())
		println("Response Body: " + response.getResponseBodyContent())
		return response.getResponseBodyContent()
	}
}
