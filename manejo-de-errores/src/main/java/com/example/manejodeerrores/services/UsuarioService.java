package com.example.manejodeerrores.services;

import java.util.List;
import java.util.Optional;

import com.example.manejodeerrores.domain.Usuario;

public interface UsuarioService {
    public List<Usuario> listar();
    public Usuario obtenerPorId(Usuario u);
    public Optional<Usuario> obtenerPorIdConOptional(Usuario u);
}
