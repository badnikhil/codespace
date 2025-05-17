package com.example;






















import org.asynchttpclient.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try (AsyncHttpClient asyncHttpClient = Dsl.asyncHttpClient()) {
            String url = "https://api.apidash.dev/humanize/social";
            BoundRequestBuilder requestBuilder = asyncHttpClient.prepare("GET", url);
           
            requestBuilder.addQueryParam("num", "8700000");  
            requestBuilder.addQueryParam("add_space", "true"); 
            requestBuilder
                .addHeader("User-Agent", "Test Agent");
            Future<Response> whenResponse = requestBuilder.execute();
            Response response = whenResponse.get();
            InputStream is = response.getResponseBodyAsStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
            String respBody = br.lines().collect(Collectors.joining("\n"));
            System.out.println(response.getStatusCode());
            System.out.println(respBody);
        } catch (InterruptedException | ExecutionException | IOException ignored) {

        }
    }
}
