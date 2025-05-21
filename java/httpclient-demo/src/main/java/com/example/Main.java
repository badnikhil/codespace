
package com.example;




import kong.unirest.*;

public class Main {
    public static void main(String[] args) {
        final String requestURL = "https://reqres.in/api/users/2";
        final String requestBody = """
{
"name": "morpheus",
"job": "zion resident"
}""";
        HttpResponse<JsonNode> response = Unirest.put(requestURL)
                .header("x-api-key", "reqres-free-v1")
                .header("Content-Type", "application/json")
                              .body(requestBody)
        .asJson();
        System.out.println(response.getStatus());
        System.out.println(response.getBody());
    }
}


