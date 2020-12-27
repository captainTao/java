package org.example;

import java.net.http.HttpResponse;
import java.util.*;

public class App 
{
    public static void main( String[] args ) throws Exception {
        String host = "http://api.saladvideo.com";
        String router = "/app/v1/notification/_update_cid";

        Map<String, String> parameters = new TreeMap<>();
        parameters.put("sign", "c6486ae97c92d2581cd785dd5c279589");
        parameters.put("cid", "8e4e438e6b34ac28f551b3fd225be866daaf8a9a4552afc3151a3ad094f40965");
        parameters.put("appkey", "6r9czfgxgu28kefh");
        parameters.put("time", "1606291285920");
        HttpResponse<String> response = HttpHelper.post(host + router, HttpHelper.toJsonString(parameters));
        System.out.println(response.body());
        System.out.println(response.statusCode());
        System.out.println(response.headers().toString());
    }
}

