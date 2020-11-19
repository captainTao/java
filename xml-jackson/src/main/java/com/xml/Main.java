package com.xml;

import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 添加两个Maven的依赖：
 *
 * com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.10.1
 * org.codehaus.woodstox:woodstox-core-asl:4.4.1
 *
 * 官方文档：https://github.com/FasterXML/jackson
 */
/*
    @JacksonXmlElementWrapper：可用于指定List等集合类，外围标签名；
    @JacksonXmlProperty：指定包装标签名，或者指定标签内部属性名；
    @JacksonXmlRootElement：指定生成xml根标签的名字；
    @JacksonXmlText：指定当前这个值，没有xml标签包裹
* */
public class Main {
    public static void main( String[] args ) throws Exception {
        InputStream input = new FileInputStream("/Users/captain/Desktop/xml-jackson/src/main/java/book.xml");

        JacksonXmlModule module = new JacksonXmlModule();
        XmlMapper mapper = new XmlMapper(module);
        Book book = mapper.readValue(input, Book.class);

        System.out.println(book.id);
        System.out.println(book.name);
        System.out.println(book.author);
        System.out.println(book.tags);
        System.out.println(book.pubDate);
        System.out.println(book.egg);
        System.out.println(book.dog);

        System.out.println(book.isbn);
        System.out.println("节点isbn的值为:" + book.isbn.value);
        System.out.println("节点isbn的属性lang的值为:" + book.isbn.lang);

    }
}
