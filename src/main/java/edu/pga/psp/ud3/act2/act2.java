package edu.pga.psp.ud3.act2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class act2 {

    private static final HttpClient cliente = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {
        try {
            System.out.println("--- INICIANDO CLIENTE HTTP ---\n");


            obtenerPosts();

            obtenerUnPost(1);

            obtenerComentarios(1);

            crearPost();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void obtenerPosts() throws IOException, InterruptedException {
        String url = "https://dummyjson.com/posts?limit=3";
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

        HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

        PostResponse respuestaObj = gson.fromJson(response.body(), PostResponse.class);

        mostrarResultado("GET", url, response.statusCode(), null, response.body());

        System.out.println("--- Datos Procesados ---");
        System.out.println("Total de posts: " + respuestaObj.total);
        if(!respuestaObj.posts.isEmpty()) {
            System.out.println("Ejemplo: " + respuestaObj.posts.getFirst().title);
        }
        System.out.println("===========================================\n");
    }

    private static void obtenerUnPost(int id) throws IOException, InterruptedException {
        String url = "https://dummyjson.com/posts/" + id;
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

        HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

        Post post = gson.fromJson(response.body(), Post.class);

        mostrarResultado("GET", url, response.statusCode(), null, response.body());
        System.out.println("--- Datos Procesados ---");
        System.out.println("Post obtenido: ID " + post.id);
        System.out.println("Reacciones: " + post.reactions);
        System.out.println("===========================================\n");
    }

    private static void obtenerComentarios(int postId) throws IOException, InterruptedException {
        String url = "https://dummyjson.com/posts/" + postId + "/comments";
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

        HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());

        CommentResponse commentsObj = gson.fromJson(response.body(), CommentResponse.class);

        mostrarResultado("GET", url, response.statusCode(), null, response.body());


        System.out.println("Primer comentario: ");
        if (commentsObj.comments != null && !commentsObj.comments.isEmpty()) {
            System.out.println(commentsObj.comments.getFirst().toString());
        }
        System.out.println("...");
        System.out.println("===========================================\n");
    }

    private static void crearPost() throws IOException, InterruptedException {
        String url = "https://dummyjson.com/posts/add";


        Post nuevoPost = new Post("Mi Título Java", "Contenido enviado desde Gson", 5);


        String jsonBody = gson.toJson(nuevoPost);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());


        Post postCreado = gson.fromJson(response.body(), Post.class);

        mostrarResultado("POST", url, response.statusCode(), jsonBody, response.body());
        System.out.println("--- Datos Procesados ---");
        System.out.println("Post creado con ID: " + postCreado.id);
        System.out.println("===========================================\n");
    }

    private static void mostrarResultado(String metodo, String url, int codigo, String enviado, String recibido) {
        System.out.println("===========================================");
        System.out.println("MÉTODO: " + metodo);
        System.out.println("URL: " + url);
        System.out.println("Código de estado: " + codigo + (codigo >= 200 && codigo < 300 ? " OK" : " Error"));

        if (enviado != null) {
            System.out.println("Cuerpo enviado (JSON generado):");
            System.out.println(enviado);
        }

        System.out.println("Respuesta (JSON recibido):");

        if (recibido.length() > 600) {
            System.out.println(recibido.substring(0, 600) + "... [TRUNCADO]");
        } else {
            System.out.println(recibido);
        }
    }
}