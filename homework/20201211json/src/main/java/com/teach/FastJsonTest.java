package com.teach;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * public static final Object parse(String text); // 把JSON文本parse为JSONObject或者JSONArray
 * public static final JSONObject parseObject(String text)； // 把JSON文本parse成JSONObject
 * public static final <T> T parseObject(String text, Class<T> clazz); // 把JSON文本parse为JavaBean
 * public static final JSONArray parseArray(String text); // 把JSON文本parse成JSONArray
 * public static final <T> List<T> parseArray(String text, Class<T> clazz); //把JSON文本parse成JavaBean集合
 * <p>
 * public static final String toJSONString(Object object); // 将JavaBean序列化为JSON文本
 * public static final String toJSONString(Object object, boolean prettyFormat); // 将JavaBean序列化为带格式的JSON文本
 * public static final Object toJSON(Object javaObject); //将JavaBean转换为JSONObject或者JSONArray。
 */

public class FastJsonTest {

    public static void main(String[] args) {
        FastJsonTest f1 = new FastJsonTest();
        f1.object2Json();
        f1.Json2Object();
    }

    /**
     * java对象转 json字符串
     */
    public void object2Json() {
        // 简单java类转json字符串
        User user = new User("Tim", "12345");
        String UserJson = JSON.toJSONString(user);
        System.out.println("简单java类转json字符串:" + UserJson);

        // List<Object>转json字符串
        User user1 = new User("San", "123123");
        User user2 = new User("Si", "321321");
        List<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        String ListUserJson = JSON.toJSONString(users);
        System.out.println("List<Object>转json字符串:" + ListUserJson);

        //复杂java类转json字符串
        UserGroup userGroup = new UserGroup("userGroup", users);
        String userGroupJson = JSON.toJSONString(userGroup);
        System.out.println("复杂java类转json字符串:" + userGroupJson);

    }

    /**
     * json字符串转java对象
     * 注：字符串中使用双引号需要转义 (" --> \"),这里使用的是单引号
     */
    public void Json2Object() {
        /*
         * json字符串转简单java对象
         * */

        String jsonStr1 = "{'password':'123456','username':'dmego'}";
        User user = JSON.parseObject(jsonStr1, User.class);
        System.out.println("json字符串转简单java对象:" + user.toString());

        /*
         * json字符串转List<Object>对象
         */
        String jsonStr2 = "[{'password':'123123','username':'zhangsan'},{'password':'321321','username':'lisi'}]";
        List<User> users = JSON.parseArray(jsonStr2, User.class);
        System.out.println("json字符串转List<Object>对象:" + users.get(1));

        /*
         * json字符串转复杂java对象
         * */
        String jsonStr3 = "{'name':'userGroup','users':[{'password':'123123','username':'zhangsan'},{'password':'321321','username':'lisi'}]}";
        UserGroup userGroup = JSON.parseObject(jsonStr3, UserGroup.class);
        System.out.println("json字符串转复杂java对象:" + userGroup);
    }

}
