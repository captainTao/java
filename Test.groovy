import groovy.json.JsonSlurper
import groovy.json.JsonOutput
import org.codehaus.groovy.ast.stmt.CatchStatement


def removeKeyFromJson(Object json, String keyToRemove) {
    def list = keyToRemove.tokenize(".")

    if (json instanceof Map) {
        if (list.size() == 1) {
            json.remove(keyToRemove)
        } else {
            def popKey = list.removeAt(0)
            println("popKey= " + popKey)
            keyToRemove = list.join(".")
            def res = splitByRegex(popKey)
            println("res= " + res)
//            res = [hobbies, 0]
//            "hobbies": ["reading", {"type": "indoor", "name": "chess"}]
            if (res instanceof List) {
                json.each { k, v ->
                    println(k,v)
                    if (k == res[0]) {
                        def index = res[1].toInteger()
                        json[k] = removeKeyFromJson(v[index], keyToRemove)
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
        // 如果是List对象，递归处理List中的每个元素
        json = json.collect { removeKeyFromJson(it, keyToRemove) }
    }
    return json
}

def splitByRegex(str) {
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

// 示例嵌套JSON字符串
def jsonStr = '{"person": {"name": "Bob", "age": 30}, "hua": {"name":{"gender":"girl"}, "age": 28}, "hobbies": ["reading", {"type": "indoor", "name": "chess"}]}'
// 解析JSON字符串为对象
def jsonSlurper = new JsonSlurper()
def jsonObj = jsonSlurper.parseText(jsonStr)

// 要移除的key
def keyToRemove = "hobbies[0].name"
def res = splitByRegex(keyToRemove)
println(res)
// 调用递归函数移除指定key
def newJsonObj = removeKeyFromJson(jsonObj, keyToRemove)

// 将处理后的对象转换回JSON字符串
def newJsonStr = JsonOutput.toJson(newJsonObj)
println(newJsonStr)