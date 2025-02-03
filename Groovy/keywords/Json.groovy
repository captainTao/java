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

import internal.GlobalVariable
import groovy.json.JsonOutput
import groovy.json.JsonSlurper

public class Json {
  /*
   * return json keys path with index if List exist
   * */
  @Keyword
  static List getAllKeysPathsWithIndex(def jsonData, String parentKey = "") {
    def keyPaths = []
    if (jsonData instanceof Map) {
      jsonData.each { key, value ->
        def currentKey = parentKey ? "$parentKey.$key" : key
        keyPaths << currentKey
        keyPaths.addAll(getAllKeysPathsWithIndex(value, currentKey))
      }
    } else if (jsonData instanceof List) {
      jsonData.eachWithIndex { item, index ->
        def currentKey = "$parentKey[$index]"
        keyPaths.addAll(getAllKeysPathsWithIndex(item, currentKey))
      }
    }
    return keyPaths
  }


  /*
   * return json keys path without index, all keys are unique
   * */
  @Keyword
  static List getAllKeysPaths(def jsonData, String parentKey = "", Set<String> existingPaths = new HashSet<>()) {
    def keyPaths = []
    if (jsonData instanceof Map) {
      jsonData.each { key, value ->
        def currentKey = parentKey ? "$parentKey.$key" : key
        if (!existingPaths.contains(currentKey)) {
          keyPaths << currentKey
          existingPaths.add(currentKey)
          keyPaths.addAll(getAllKeysPaths(value, currentKey, existingPaths))
        }
      }
    } else if (jsonData instanceof List) {
      jsonData.each { item ->
        keyPaths.addAll(getAllKeysPaths(item, parentKey, existingPaths))
      }
    }
    return keyPaths
  }
  /**
   * remove specific key of json string by keys list
   * */
  @Keyword
  static String removeKeyPathFromJsonByList(String jsonStr, List<String> keyPathsToRemove, Boolean pretty = true) {
    def jsonObj = new JsonSlurper().parseText(jsonStr)
    keyPathsToRemove.each { keyPath ->
      def keyParts = keyPath.split("\\.")
      removeKeyPathRecursively(jsonObj, keyParts, 0)
    }
    def jsonOutString = JsonOutput.toJson(jsonObj)
    if (pretty) {
      return JsonOutput.prettyPrint(jsonOutString)
    }
    return jsonOutString
  }


  /**
   * remove specific key of json string by key string
   * */
  @Keyword
  static String removeKeyPathFromJson(String jsonStr, String keyPathToRemove, Boolean pretty = true) {
    def jsonObj = new JsonSlurper().parseText(jsonStr)
    def keyParts = keyPathToRemove.split("\\.")
    removeKeyPathRecursively(jsonObj, keyParts, 0)
    def jsonOutString = JsonOutput.toJson(jsonObj)
    if (pretty) {
      return JsonOutput.prettyPrint(jsonOutString)
    }
    return jsonOutString
  }

  /**
   * remove json key recursively
   * */
  @Keyword
  static void removeKeyPathRecursively(obj, keyParts, index) {
    if (index == keyParts.size()) {
      return
    }
    def currentKey = keyParts[index]
    if (obj instanceof Map) {
      if (index == keyParts.size() - 1) {
        obj.remove(currentKey)
      } else {
        def nextObj = obj[currentKey]
        if (nextObj != null) {
          removeKeyPathRecursively(nextObj, keyParts, index + 1)
        }
      }
    } else if (obj instanceof List) {
      obj.each { item ->
        removeKeyPathRecursively(item, keyParts, index)
      }
    }
  }

  /**
   * parseStringToJson
   * */
  @Keyword
  static Object parseStringToJsonObject(String jsonStr) {
    def jsonSlurper = new JsonSlurper()
    return jsonSlurper.parseText(jsonStr)
  }

  /**
   * parseJsonToString
   * */
  @Keyword
  static String parseJsonToString(Object jsonMap, Boolean pretty = true) {
    def JsonStr = JsonOutput.toJson(jsonMap)
    if (pretty == true) {
      return JsonOutput.prettyPrint(JsonStr)
    } else {
      return JsonStr
    }
  }
}
