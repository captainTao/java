import groovy.json.JsonSlurper
import groovy.json.JsonOutput


def removeKeyFromJson(Object json, String keyToRemove) {
    def list = keyToRemove.tokenize(".")
    if (json instanceof Map) {
        if (list.size() == 1) {
            json.remove(keyToRemove)
        } else {
            def popKey = list.removeAt(0)
            println("popKey= " + popKey)
            keyToRemove = list.join(".")
            def locateStr = isArrayStrByRegex(popKey)
            println("locateStr= " + locateStr)
            if (locateStr instanceof List) {
                json.each { k, v ->
                    if (k == locateStr[0]) {
                        def index = locateStr[1].toInteger()
                        json[k][index] = removeKeyFromJson(v[index], keyToRemove)
                    }
                }
            } else {
                json.each { k, v ->
                    if (k == popKey) {
                        json[k] = removeKeyFromJson(v, keyToRemove)
                    }
                }
            }
        }
    } else if (json instanceof List) {
        json = json.collect { removeKeyFromJson(it, keyToRemove) }
    }
    return json
}

def isArrayStrByRegex(str) {
    def pattern = /(\w+)\[(\d+)\]/
    def matcher = (str =~ pattern)
    try {
        if (matcher.matches()) {
            def key = matcher.group(1)
            def index = matcher.group(2)
            println("key: $key, index: $index")
            return [key, index]
        } else {
            println("No match found for input: $str")
            return str
        }
    } catch (Exception e) {
        println("An error occurred: ${e.message}")
        throw e
    }
}

def jsonStr = '{"person": {"name": "Bob", "age": 30}, "hua": {"name":{"gender":"girl"}, "age": 28}, "hobbies": ["reading", {"type": "indoor", "name": "chess"}, {"type": "outdoor", "name": "football"}]}'
def jsonSlurper = new JsonSlurper()
def jsonObj = jsonSlurper.parseText(jsonStr)

def keyToRemove = "hobbies[1].name"
def newJsonObj = removeKeyFromJson(jsonObj, keyToRemove)
def newJsonStr = JsonOutput.toJson(newJsonObj)
println(newJsonStr)