package com.ascencio.service;

import com.google.gson.Gson;
import com.ascencio.config.HttpClientConfig;
import com.ascencio.model.PrediccionBody;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PrediccionServiceImpl extends HttpClientConfig implements PrediccionService {

    String URL = "https://bigml.io/andromeda/";
    String CREDENCIALES = "?username=ciurlizzaascencio;api_key=cbb20783a3a5dd772857123041bc33f91709f4e0";

    @Override
    public HttpResponse<String> predecir(PrediccionBody prediccionBody) throws IOException, InterruptedException {
        // Formateo de datos a String
        String json = new Gson().toJson(prediccionBody);

        // Agregando JSON a body
        HttpRequest request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .uri(URI.create(URL + "prediction" + CREDENCIALES))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .header("Content-Type", "application/json")
                .build();
        HttpResponse<String> response = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response;
    }

    @Override
    public HttpResponse<String> listar() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(URL + "prediction" + CREDENCIALES))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .build();
        HttpResponse<String> response = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response;
    }

    @Override
    public HttpResponse<String> buscarPrediccionId(String idPrediccion) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(URL + idPrediccion + CREDENCIALES))
                .setHeader("User-Agent", "Java 11 HttpClient Bot") // add request header
                .build();
        HttpResponse<String> response = getHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response;
    }

}
