package com.json;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * getResourceAsStream获取不到文件？？
 */
public class Main
{
    public static void main( String[] args ) throws IOException {
        // InputStream input = Main.class.getResourceAsStream("book.json");
        InputStream input = new FileInputStream("/Users/captain/Desktop/json/src/main/java/com/json/book.json");
        System.out.println(input);
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());
        // 反序列化时忽略不存在的JavaBean属性:
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Book book = mapper.readValue(input, Book.class);
        System.out.println(book.id);
        System.out.println(book.name);
        System.out.println(book.author);
        System.out.println(book.isbn);
        System.out.println(book.tags);
        System.out.println(book.pubDate);
        System.out.println(book.price);
        // 序列化为JSON:
        String json = mapper.writeValueAsString(book);
        System.out.println(json);
    }
}
