package com.example.manejodeerrores.errors;

public class UsuarioNoEncontradoException extends RuntimeException{

    public UsuarioNoEncontradoException(String id) {
        super("Usuario con ID ".concat(id).concat(" no existe en la base de datos!"));
    }
    
}
