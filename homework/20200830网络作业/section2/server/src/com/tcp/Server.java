package com.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(6666); // 监听指定端口
        System.out.println("server is running...");
        for (; ; ) {
            Socket sock = ss.accept();
            System.out.println("connected from " + sock.getRemoteSocketAddress());
            Thread t = new Handler(sock);
            t.start();
        }
    }
}

class Handler extends Thread {
    Socket sock;

    public Handler(Socket sock) {
        this.sock = sock;
    }

    @Override
    public void run() {
        try (InputStream input = this.sock.getInputStream()) {
            try (OutputStream output = this.sock.getOutputStream()) {
                handle(input, output);
            }
        } catch (Exception e) {
            try {
                this.sock.close();
            } catch (IOException ioe) {
            }
            System.out.println("client disconnected.");
        }
    }

    private void handle(InputStream input, OutputStream output) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        var writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
        writer.write("Connected successfully, Input the file path to upload.\nOr 'bye' to end upload.\n");
        writer.flush();

        // 创建文件夹
        String folder = "/Users/captain/Desktop/Test";
        if (!new File(folder).exists()) {
            new File(folder).mkdirs();
        }
        // 读取输入信息
        for (; ; ) {
            String s = reader.readLine();
            String filePath = folder + "/" + s;
            if (!new File(filePath).exists() && !s.equals("null")) {
                new File(filePath).createNewFile();
            }
            try (OutputStream outputFile = new FileOutputStream(filePath);
                 var writerLocal = new BufferedWriter(new OutputStreamWriter(outputFile))) {
                while (true) {
                    String line = reader.readLine();
                    if (line.equals("null")) {
                        break;
                    } else {
                        writerLocal.write(line);
                        writerLocal.newLine();
                        writerLocal.flush();
                    }
                }
            }
            String message = "[server:]  write " + s + " ok\n";
            writer.write(message);
            writer.flush();
            System.out.println(message.trim());
            System.out.println("waiting for next cmd...");
        }
    }
}
