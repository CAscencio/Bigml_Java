package com.example.rest.service;

import com.example.rest.config.HttpClientConfig;
import com.example.rest.model.PrediccionBody;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class PrediccionServiceImpl extends HttpClientConfig implements PrediccionService {

    @Autowired
    private ObjectMapper objectMapper;

    String URL = "https://bigml.io/andromeda/";
    String CREDENCIALES = "?username=marcosalarcon;api_key=7081e0eeee307b313644781c3e6859290fe11479";

    @Override
    public HttpResponse<String> predecir(PrediccionBody prediccionBody) throws IOException, InterruptedException {

        // Formateo de datos a String
        String json = objectMapper.writeValueAsString(prediccionBody);

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
