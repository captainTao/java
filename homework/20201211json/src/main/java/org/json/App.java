package org.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import com.alibaba.fastjson.JSON;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class App {
    public static void main(String[] args) {
        String result = getResultFromPath("assets/test.json");

        Gson gson = new Gson();
        ArrayList<UserList> userLists = gson.fromJson(result, new TypeToken<ArrayList<UserList>>() {
        }.getType());
        assert userLists != null;
        System.out.println(userLists);

        List<UserList> lists = JSON.parseArray(result, UserList.class);
        System.out.println(lists);
    }

    public static String getResultFromPath(String path) {
        try {
            InputStream inputStream = new FileInputStream(path);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = br.readLine()) != null) {
                builder.append(line);
            }
            return builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
