package com.ceiba.biblioteca.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class Exception extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserTypeNotAllowedException.class)
    public ResponseEntity<Object> UserTypeNotAllowedException(UserTypeNotAllowedException ex, WebRequest request){

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("mensaje", "Tipo de usuario no permitido en la biblioteca");

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<Object> ForbiddenException(ForbiddenException ex, WebRequest request){

        Map<String,Object> body = new LinkedHashMap<>();
        body.put("mensaje", ex.getMessage());

        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
