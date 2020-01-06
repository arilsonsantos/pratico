package br.com.orion.pratico.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class AbstractResponseController {

    
    public abstract ResponseEntity<?> findAll();      

        
    protected ResponseEntity<?> resposta(HttpStatus status) {
        return resposta(null, status);
    }

    protected ResponseEntity<?> resposta(Object object, HttpStatus status) {
        return new ResponseEntity<>(object, status);
    }
}