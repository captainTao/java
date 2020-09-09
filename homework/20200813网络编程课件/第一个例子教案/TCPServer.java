package com.TCPTest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
	public static void main(String[] args) {
		try {
			ServerSocket server = new ServerSocket(8889);
			Socket socket =server.accept();
			InputStream inputStream = socket.getInputStream();
			byte[] bytes = new byte[1024];
			int len = inputStream.read(bytes);
			System.out.println("收到客户端请求："+ new String(bytes,0,len));
			
			OutputStream outputStream = socket.getOutputStream();
			outputStream.write("服务端：收到！".getBytes());
			
			socket.close();
			server.close();
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
