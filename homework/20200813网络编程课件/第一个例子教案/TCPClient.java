package com.TCPTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
 	TCP通信的客户端：向服务器发送连接请求，向服务器发送数据，读取服务器回写的数据
 	表示客户端的类：
	java.net.Scoket;此类实现客户端套接字，套接字是两台机器间通信的端点
	套接字：包含了IP地址和端口号的网络单位
	
	实现步骤：
	1.创建一个客户端对象Socket,构造方法绑定服务器的IP地址各端口号
	2.使用Socket对象中的方法getOutputStream()获取网络字节输出流getOutputStream对象
	3.使用网络字节输出流getOutputStream对象中的方法write,给服务器发送数据
	4、使用Socket对象中的方法getInputStream()获取网络字节输入流getInputStream对象
	5、使用网络字节输入流getInputStream对象中的方法read,读取服务器回写的数据
	6、释放资源Socket
	
	注意：
	1、客户端与服务端进行交互，必须使用Socket中提供的网络流，不能使用自己创建的流对象
	2、当我们创建客户端Socket对象的时候，就会去请求服务器，和服务器进行三次握手，建立连接通路；
	如服务器没有启动，就会抛出异常
	如服务器启动了，就可以正常交互
 */
public class TCPClient {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1",8889);
			
			OutputStream outputStream = socket.getOutputStream();
			outputStream.write("你好，服务器！".getBytes());
		
			
			InputStream inputStream = socket.getInputStream();
			byte[] bytes = new byte[1024];
			int len = inputStream.read(bytes);
			System.out.println(new String(bytes,0,len));
			
			
			socket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
}
