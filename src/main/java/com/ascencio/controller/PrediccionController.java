package com.ascencio.controller;

import com.ascencio.dto.PredListResDTO;
import com.ascencio.dto.PredResDTO;
import com.ascencio.model.PrediccionBody;
import com.ascencio.service.PrediccionServiceImpl;
import com.google.gson.Gson;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@Named(value = "prediccionController")
@SessionScoped
public class PrediccionController implements Serializable {
    
    private PrediccionServiceImpl prediccionService;
    Gson gson;

    public PrediccionController() {
        prediccionService = new PrediccionServiceImpl();
        gson = new Gson();
    }

    public void listar() throws IOException, InterruptedException {
        String response = prediccionService.listar().body();
        PredListResDTO predListResDTO = gson.fromJson(response, PredListResDTO.class);
    }

    public void predecir(PrediccionBody prediccionBody) throws IOException, InterruptedException {
        String response = prediccionService.predecir(prediccionBody).body();
        PredResDTO predResDTO = gson.fromJson(response, PredResDTO.class);
    }

    public void buscarPrediccionId(String idPrediccion) throws IOException, InterruptedException {
        String response = prediccionService.buscarPrediccionId(idPrediccion).body();
        PredResDTO predListResDTO = gson.fromJson(response, PredResDTO.class);
    }

    public PrediccionServiceImpl getPrediccionService() {
        return prediccionService;
    }

    public void setPrediccionService(PrediccionServiceImpl prediccionService) {
        this.prediccionService = prediccionService;
    } 
    
}
