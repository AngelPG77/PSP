package edu.pga.psp.ud3.act1;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Test {

    public static void main(String[] args) throws IOException, InterruptedException {

        HttpClient cliente = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://dummyjson.com/comments"))
                .GET()
                .build();

        HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status: " + response.statusCode());
        System.out.println("Body: " + response.body());


        String json = """
                {
                "body":"Example",
                "userId": 123
                }
                """;

        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(URI.create("https://dummyjson.com/posts/add"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> response2 = cliente.send(request2, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status: " + response2.statusCode());
        System.out.println("Body: " + response2.body());

    }
}
