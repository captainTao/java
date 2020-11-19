package com.xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

import java.util.List;

public class Book {
    public long id;
    public String name;
    public String author;
//    public String isbn;
    @JacksonXmlProperty(localName = "isbn")
    public BookAttr isbn;
    public List<String> tags;
    public String pubDate;
    public String egg;
    public String dog;
}

class BookAttr {
    @JacksonXmlProperty(isAttribute=true, localName="lang")
    public String lang;
    @JacksonXmlText
    public String value;
}