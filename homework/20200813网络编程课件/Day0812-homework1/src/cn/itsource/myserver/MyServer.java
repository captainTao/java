package cn.itsource.myserver;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *	服务器端
 *		需要用ServerSocket类，监听一个端口，等待客户端连接
 */
public class MyServer {
	/**声明一个ServerSocket的成员变量*/
	private ServerSocket server;
	
	/**
	 * 构造方法初始化，一个ServerSocket对象，监听端口
	 */
	public MyServer() {
		try {
			System.out.println("正在监听端口....");
			server = new ServerSocket(6666);
			System.out.println("监听端口成功！");
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
		//为了一直可以让客户端连接到服务器，要用死循环，一直等待连接
		System.out.println("等待客户端连接....");
		while (true) {
			//获取一个客户端连接对象
			Socket client = server.accept();
			System.out.println("一个客户端连接进来了： " + client);
			//准备两个流：文件输出流，client输入流
			InputStream is = client.getInputStream();
			//将客户端上传的文件存到服务器里面
//			ObjectInputStream ois = new ObjectInputStream(is);
			
			OutputStream os = new FileOutputStream("wow.txt");
			System.out.println("开始读取文件...");
			byte[] bytes = new byte[1024];
			int len = 0;
			while((len = is.read(bytes)) != -1) {
				os.write(bytes);
				os.flush();
			}
//			
//			//读取的数组长度
//			int len = ois.readInt();
//			
//			//读取次数
//			long times = ois.readLong();
//			
//			//读取最后一次字节长度
//			
//			int lasstBytes = ois.readInt();
//			
//			byte[] bytes = new byte[len];
//			
//			while(times >1) {
//				ois.readFully(bytes);
//				os.write(bytes);
//				os.flush();
//				times --;
//			}
			
			System.out.println("文件接收完毕！已保存到服务器。");
			if(os != null) {
				os.close();
			}
		}
	}
	
	public static void main(String[] args) {
		//直接创建对象，然后调用start方法
		try {
			new MyServer().start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
