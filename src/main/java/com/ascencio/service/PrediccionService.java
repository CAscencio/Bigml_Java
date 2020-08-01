package com.ascencio.service;

import com.ascencio.model.PrediccionBody;
import java.io.IOException;
import java.net.http.HttpResponse;

public interface PrediccionService {

    public HttpResponse<String> predecir(PrediccionBody prediccionBody) throws IOException, InterruptedException;

    public HttpResponse<String> listar() throws IOException, InterruptedException;

    public HttpResponse<String> buscarPrediccionId(String idPrediccion) throws IOException, InterruptedException;
}
