package com.example.manejodeerrores.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.manejodeerrores.domain.Usuario;

@Service("service")
public class UsuarioServiceImpl implements UsuarioService {

    private List<Usuario> lista;

    public UsuarioServiceImpl() {
        this.lista = Arrays.asList(
            new Usuario(1, "Pedro", "Sanchez"),
            new Usuario(2, "Ana", "Ramirez"),
            new Usuario(3, "Maria", "Diaz")
        );
    }

    @Override
    public List<Usuario> listar() {
        return this.lista;
    }

    @Override
    public Usuario obtenerPorId(Usuario u) {
        Usuario result = null;
        for (Usuario data : this.lista) {
            if (u.getId().equals(data.getId())) {
                result = data;
                break;
            }
        }
        return result;
    }

    @Override
    public Optional<Usuario> obtenerPorIdConOptional(Usuario u) {
        Usuario result = this.obtenerPorId(u);
        return Optional.ofNullable(result);
    }
    
}
