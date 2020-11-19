package com.itranswarp.learnjava;

import java.io.InputStream;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

/**
 * XML是可扩展标记语言（eXtensible Markup Language）的缩写;
 * XML使用嵌套结构的数据表示方式，支持格式验证；
 * XML常用于配置文件、网络消息传输等。
 *
 * book.xml:
 *
 * <?xml version="1.0" encoding="UTF-8" ?>
 *
 * <book id="1">
 *     <name>Java核心技术</name>
 *     <author>Cay S. Horstmann</author>
 *     <isbn lang="CN">1234567</isbn>
 *     <tags>
 *         <tag>Java</tag>
 *         <tag>Network</tag>
 *     </tags>
 *     <pubDate/>
 * </book>
 *
 *
 * 特殊符号，需要使用 &??; 表示转义。
 * 例如，Java<tm>必须写成：
 * <name>Java&lt;tm&gt;</name>
 *
 * 特殊字符表示：
 *
 * <   &lt;
 * >   &gt;
 * &   &amp;
 * "   &quot;
 * '   &apos;
 * 
 * 合法的XML是指，不但XML格式正确，而且它的数据结构可以被DTD或者XSD验证。
 * 如何验证XML文件的正确性呢？
 * 最简单的方式是通过浏览器验证。
 * 可以直接把XML文件拖拽到浏览器窗口，如果格式错误，浏览器会报错。
 *
 * XML是一种树形结构的文档，它有两种标准的解析API：
 * DOM：一次性读取XML，并在内存中表示为树形结构；
 * SAX：以流的形式读取XML，使用事件回调。
 * jackson
 */
public class Main {

	public static void main(String[] args) throws Exception {
		InputStream input = Main.class.getResourceAsStream("/book.xml");
//		InputStream inputStream = new FileInputStream("/Users/captain/Desktop/book.xml");

		// 使用DOM API 解析:
//		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//		DocumentBuilder db = dbf.newDocumentBuilder();
//		Document doc = db.parse(input);
//		printNode(doc, 0);

		// 使用SAX来解析：
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser saxParser = spf.newSAXParser();
		saxParser.parse(input, new MyHandler());
	}

	static void printNode(Node n, int indent) {
		for (int i = 0; i < indent; i++) {
			System.out.print(' ');
		}
		switch (n.getNodeType()) {
		case Node.DOCUMENT_NODE:
			System.out.println("Document: " + n.getNodeName());
			break;
		case Node.ELEMENT_NODE:
			System.out.println("Element: " + n.getNodeName());
			break;
		case Node.TEXT_NODE:
			System.out.println("Text: " + n.getNodeName() + " = " + n.getNodeValue());
			break;
		case Node.ATTRIBUTE_NODE:
			System.out.println("Attr: " + n.getNodeName() + " = " + n.getNodeValue());
			break;
		case Node.CDATA_SECTION_NODE:
			System.out.println("CDATA: " + n.getNodeName() + " = " + n.getNodeValue());
			break;
		case Node.COMMENT_NODE:
			System.out.println("Comment: " + n.getNodeName() + " = " + n.getNodeValue());
			break;
		default:
			System.out.println("NodeType: " + n.getNodeType() + ", NodeName: " + n.getNodeName());
		}
		for (Node child = n.getFirstChild(); child != null; child = child.getNextSibling()) {
			printNode(child, indent + 1);
		}
	}
}

class MyHandler extends DefaultHandler {
	public void startDocument() throws SAXException {
		print("start document");
	}

	public void endDocument() throws SAXException {
		print("end document");
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		print("start element:", localName, qName);
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		print("end element:", localName, qName);
	}

	public void characters(char[] ch, int start, int length) throws SAXException {
		print("characters:", new String(ch, start, length));
	}

	public void error(SAXParseException e) throws SAXException {
		print("error:", e);
	}

	void print(Object... objs) {
		for (Object obj : objs) {
			System.out.print(obj);
			System.out.print(" ");
		}
		System.out.println();
	}
}