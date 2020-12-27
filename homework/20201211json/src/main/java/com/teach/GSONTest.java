package com.teach;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

/**
 * Gson的基本用法
 * fromJson() 反序列化 解析json
 * toJson() 序列化 生成json
 * 每个方法都提供了重载方法
 */


public class GSONTest {

    public static void main(String[] args) {
        GSONTest t1 = new GSONTest();
        t1.test1();
        t1.test2();
        t1.test3();
    }


    public void test1() {
        Gson gson = new Gson();

        // （1）基本数据类型的解析
        // 解析对象：第一个参数：待解析的字符串 第二个参数:需要转换对象的类型
        int i = gson.fromJson("100", int.class);
        double d = gson.fromJson("99.99", double.class);
        boolean b = gson.fromJson("true", boolean.class);
        String str = gson.fromJson("String", String.class);
        System.out.println(i);
        System.out.println(d);
        System.out.println(b);
        System.out.println(str);

        // （2）基本数据类型的生成
        String jsonNumber = gson.toJson(100);       // 100
        String jsonBoolean = gson.toJson(false);    // false
        String jsonString = gson.toJson("String"); //"String"
        System.out.println(jsonNumber);
        System.out.println(jsonBoolean);
        System.out.println(jsonString);
    }


    //解析
    public void test2() {
        //对象
        String json1 = "{'id':302,'name':'三年二班', 'students':[{'id':101,'name':'小青蛙','age':16},{'id':102,'name':'小蚂蚁','age':13}]}";
        //数组
        String json2 = "['北京','天津','杭州']";

        Gson gson = new Gson();

        //解析对象：
        Grade grade = gson.fromJson(json1, Grade.class);
        System.out.println(grade);

        //解析数组要求使用Type
        ArrayList<String> list = gson.fromJson(json2, new TypeToken<ArrayList<String>>() {
        }.getType());
        System.out.println(list);
    }


    //生成
    public void test3() {
        ArrayList<Student> list = new ArrayList<>();
        for (int i = 1; i < 3; i++) {
            list.add(new Student(10 + i, "蝌蚪", 16 + i));
        }
        Grade grade = new Grade(302, "三年二班", list);
        Gson gson = new Gson();
        //将对象转换为诶JSON格式字符串
        String json = gson.toJson(grade);
        System.out.println(json);
    }

}
