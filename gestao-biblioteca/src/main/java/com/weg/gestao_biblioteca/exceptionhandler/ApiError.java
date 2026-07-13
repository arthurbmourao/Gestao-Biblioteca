package com.weg.gestao_biblioteca.exceptionhandler;

import org.springframework.http.HttpStatus;

import java.util.List;

public record ApiError(String message, List<String> erros, Integer codigo) {

    public ApiError(String message, Integer codigo){
        this(message,List.of(), codigo);
    }
}
