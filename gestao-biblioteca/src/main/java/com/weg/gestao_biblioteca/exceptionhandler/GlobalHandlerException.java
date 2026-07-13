package com.weg.gestao_biblioteca.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> handlerIlegalArgumentException(IllegalArgumentException exception){
        ApiError erro = new ApiError(
                "Requisição Inválida",
                List.of(exception.getMessage() != null ? exception.getMessage() : "Erro desconhecido"),
                HttpStatus.BAD_REQUEST.value()
        );
        return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> methodoArgumentNotValidException(MethodArgumentNotValidException exception){
        ApiError error = new ApiError(
                "Campo" + exception.getParameter() + "inválido",
                List.of(exception.getMessage() != null ? exception.getMessage() : "Erro desconhecido"),
                HttpStatus.METHOD_NOT_ALLOWED.value()
        );
        return new ResponseEntity<>(error,HttpStatus.METHOD_NOT_ALLOWED);
    }
}
