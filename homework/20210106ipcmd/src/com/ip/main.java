package com.ip;

import java.io.*;
import java.io.IOException;
/**
 * public Process exec(String command)-----在单独的进程中执行指定的字符串命令。
 * public Process exec(String [] cmdArray)---在单独的进程中执行指定命令和变量
 * public Process exec(String command, String [] envp)----在指定环境的独立进程中执行指定命令和变量
 * public Process exec(String [] cmdArray, String [] envp)----在指定环境的独立进程中执行指定的命令和变量
 * public Process exec(String command,String[] envp,File dir)----在有指定环境和工作目录的独立进程中执行指定的字符串命令
 * public Process exec(String[] cmdarray,String[] envp,File dir)----在指定环境和工作目录的独立进程中执行指定的命令和变量
 *
 * Runtime run = Runtime.getRuntime();
 * Process p = run.exec("ping 127.0.0.1");
 * InputStream ins= p.getInputStream();
 * InputStream ers= p.getErrorStream();
 * 这两个流要用不同的线程去处理，不然容易引发阻塞
 *
 * cmd命令执行窗口开闭指令
 * cmd /c dir 是执行完dir命令后关闭命令窗口。
 * cmd /k dir 是执行完dir命令后不关闭命令窗口。
 * cmd /c start dir 会打开一个新窗口后执行dir指令，原窗口会关闭。
 * cmd /k start dir 会打开一个新窗口后执行dir指令，原窗口不会关闭。
 * */
public class main {
    public static void main(String[] args) throws IOException {
        runtime();
        processBuilder();
    }

    static void runtime() throws IOException {
        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
        Process process;
        if (isWindows) {
            process = Runtime.getRuntime().exec("ipconfig");
        } else {
            process = Runtime.getRuntime().exec("ifconfig");
        }
        InputStream inputStream = process.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }

    static void processBuilder() throws IOException {
        Process process = new ProcessBuilder().command("ifconfig").start();
        InputStream in = process.getInputStream();
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        while ((line = br.readLine()) != null) {
            sb.append(line).append("\n");
        }
        String str = sb.toString();
        System.out.println(str);
    }
}