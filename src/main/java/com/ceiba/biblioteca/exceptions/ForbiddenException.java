package com.ceiba.biblioteca.exceptions;

public class ForbiddenException extends RuntimeException {
    public ForbiddenException(String identificacionUsuario) {
        super("El usuario con identificación " + identificacionUsuario + " ya tiene un libro prestado por lo cual no se le puede realizar otro préstamo");
    }
}