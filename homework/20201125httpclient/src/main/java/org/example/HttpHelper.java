package org.example;

/*
 * JDK 11 才支持！
 * author: Captain.T
 * */

import java.math.BigInteger;
import java.net.URI;
import java.net.http.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.time.Duration;
import java.util.*;


public class HttpHelper {
    private static final HttpClient httpClient = HttpClient.newBuilder().build();

    public static HttpResponse<String> get(String uri, Map<String, String> parameters) throws Exception {
        if (uri == null || uri.equals("")) {
            System.out.println("The uri parameter is empty!");
            return null;
        }
        String para = addParameters(parameters);
        String url = para.equals("") ? uri : (uri + "?" + para);
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(url))
                .header("User-Agent", "Avatar/2.7.2 (iPhone; iOS 13.6; Scale/2.00)")
                .header("Accept", "*/*")
                .header("isVip", "1")
                .header("appVersion", "2.7.2")
                .header("local", "zh_CN")
                .header("channel", "appstore")
                .header("platform", "iphone")
                .header("deviceId", "SALAD")
                .version(HttpClient.Version.HTTP_2)
                .timeout(Duration.ofSeconds(5))
                .build();
        return httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
    }

    public static HttpResponse<String> post(String uri, String body) throws Exception {
        if (uri == null || uri.equals("")) {
            System.out.println("The uri parameter is empty!");
            return null;
        }
        HttpRequest httpRequest = HttpRequest.newBuilder(new URI(uri))
                .header("User-Agent", "Avatar/2.7.5 (iPhone; iOS 13.6; Scale/2.00)")
                .header("Accept", "*/*")
                .header("isVip", "na")
                .header("appVersion", "2.7.5")
                .header("language", "zh-Hans")
                .header("local", "zh_CN")
                .header("channel", "appstore")
                .header("Content-Type", "application/json")
                .header("Accept-Encoding", "gzip, deflate")
                .header("platform", "iphone")
                .header("deviceId", "SALAD")
                .version(HttpClient.Version.HTTP_2)
                .timeout(Duration.ofSeconds(5))
                .POST(HttpRequest.BodyPublishers.ofString(body, StandardCharsets.UTF_8))
                .build();
        return httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
    }

    public static String addParameters(Map<String, String> parameters) {
        if (parameters == null || parameters.isEmpty()) {
            return null;
        }
        StringJoiner stringJoiner = new StringJoiner("&");
        for (String key : parameters.keySet()) {
            String value = parameters.get(key);
            stringJoiner.add(key + "=" + value);
        }
        return stringJoiner.toString();
    }

    public static String addParameters(Map<String, String> parameters, String joiner) {
        if (parameters == null || parameters.isEmpty() || joiner == null) {
            return null;
        }
        StringJoiner stringJoiner = new StringJoiner(joiner);
        for (String key : parameters.keySet()) {
            String value = parameters.get(key);
            stringJoiner.add(key + "=" + value);
        }
        return stringJoiner.toString();
    }

    public static String toJsonString(Map<String, String> map) {
        Iterator<Map.Entry<String, String>> i = map.entrySet().iterator();
        if (!i.hasNext())
            return "{}";
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        for (; ; ) {
            Map.Entry<String, String> e = i.next();
            Object key = e.getKey();
            Object value = e.getValue();
            sb.append("\t\"").append(key).append("\"");
            sb.append(" : ");
            sb.append("\"").append(value).append("\"");
            if (!i.hasNext())
                return sb.append("\n}").toString();
            sb.append(",\n").append(' ');
        }
    }
}
