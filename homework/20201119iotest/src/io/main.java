package io;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class main {
    public static void main(String[] args) throws IOException {
        String folder_path = "/Users/captain/Desktop/iotest/save/";
        File file_folder = new File(folder_path);
        if (!file_folder.exists()) {
            file_folder.mkdirs();
        }
        URL url = new URL("http://www.51gjie.com/Images/image1/lkqixikw.lqs.jpg");
        URLConnection connection = url.openConnection();
        InputStream inputStream = connection.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(new File(folder_path + "test.jpg")));
        int c;
        byte[] temp = new byte[1024 * 2];
        while ((c = bufferedInputStream.read(temp)) != -1) {
            bufferedOutputStream.write(temp,0, c);
        }
        bufferedOutputStream.close();
        inputStream.close();
    }
}
