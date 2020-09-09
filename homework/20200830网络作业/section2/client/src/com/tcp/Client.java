package com.tcp;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket sock = new Socket("localhost", 6666); // 连接指定服务器和端口
        try (InputStream input = sock.getInputStream()) {
            try (OutputStream output = sock.getOutputStream()) {
                handle(input, output);
            }
        }
        sock.close();
        System.out.println("disconnected.");
    }

    private static void handle(InputStream input, OutputStream output) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        var writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
        Scanner scanner = new Scanner(System.in);
        System.out.println("[server:] " + reader.readLine());
        System.out.println("[server:] " + reader.readLine());
        for (; ; ) {
            System.out.print(">>> ");
            String filePath = scanner.nextLine().trim();
            if (filePath.equals("bye")) {
                break;
            }
            if (new File(filePath).exists()) {
                writer.write(new File(filePath).getName());
                writer.newLine();
                writer.flush();
                try (InputStream inputFile = new FileInputStream(filePath)) {
                    inputFile.transferTo(output);
                    writer.newLine();
                    writer.write("null\n");
                    writer.flush();
                }
                String resp = reader.readLine();
                System.out.println("<<< " + resp);
            } else {
                System.out.println("path illegal. try again!");
            }
        }
    }
}