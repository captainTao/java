package cn.itsource.myclient;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 *	客户端
 *		需要用Socket类
 */
public class MyClient {
	/**声明一个Socket的成员变量*/
	private Socket client;
	
	/**
	 * 构造方法初始化，一个ServerSocket对象，监听端口
	 */
	public MyClient() {
		try {
			System.out.println("正在连接服务端....");
			//Socket(String host, int port) 构造方法
			client = new Socket("localhost",6666) ;
			System.out.println("连接成功！");
		} catch (IOException e) {
			System.err.println("监听端口失败！");
			e.printStackTrace();
		}
	}
	
	/**
	 * 启动服务端的方法，该方法负责获取客户端的连接对象，并且进而获取输入流，然后读取数据
	 * @throws IOException 
	 */
	public void start() throws IOException {
		//通过Socket对象获取一个输出流
		OutputStream os = client.getOutputStream();
		InputStream is = new FileInputStream("Users/lurao/Desktop/hello");
		byte[] bytes = new byte[1024];
		int len = 0;
		
		while((len = is.read(bytes)) != -1) {
			os.write(bytes);
		}
		
		os.close();
		is.close();
	}
	
	public static void main(String[] args) {
		//直接创建对象，然后调用start方法
		try {
			new MyClient().start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
