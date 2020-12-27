package com.teach;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

/**
 * Jackson的所有JSON操作都是在ObjectMapper中实现。
 * readValue() 反序列化 解析json
 * readValue(String content, Class<T> valueType)；简单型，就是 直接  UserBase.class 就可。
 * readValue(String content, TypeReference<T> valueTypeRef)；复杂的可以 用这个
 * <p>
 * writeValue() 序列化 ，生成json
 * writeValue(File arg0, Object arg1)把arg1转成json序列，并保存到arg0文件中。
 * writeValue(OutputStream arg0, Object arg1)把arg1转成json序列，并保存到arg0输出流中。
 * writeValueAsBytes(Object arg0)把arg0转成json序列，并把结果输出成字节数组。
 * writeValueAsString(Object arg0)把arg0转成json序列，并把结果输出成字符串。
 */

public class JackSonTest {

    public static void main(String[] args) throws JsonProcessingException {
        JackSonTest j1 = new JackSonTest();
        j1.test1();
        j1.test2();
    }

    // 解析
    public void test1() throws JsonProcessingException {
        // 对象
        String json1 = "{\"id\":302,\"name\":\"三年二班\",\"members\":[{\"id\":101,\"name\":\"小青蛙\",\"age\":16},{\"id\":102,\"name\":\"小蚂蚁\",\"age\":13}]}";
        // 数组
        String json2 = "[\"北京\",\"天津\",\"杭州\"]";

        ObjectMapper mapper = new ObjectMapper();
        Grade grade = mapper.readValue(json1, Grade.class);
        System.out.println(grade);

        ArrayList<String> list = mapper.readValue(json2, new TypeReference<ArrayList<String>>() {});
        System.out.println(list);
    }


    // 生成
    public void test2() throws JsonProcessingException {
        ArrayList<Student> list = new ArrayList<>();
        for (int i = 1; i < 3; i++) {
            list.add(new Student(80 + i, "蝌蚪", 14 + i));
        }

        Grade grade = new Grade(302, "一年二班", list);
        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(grade);
        System.out.println(json);
    }

}
