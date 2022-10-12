package com.example.manejodeerrores.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.manejodeerrores.domain.Usuario;
import com.example.manejodeerrores.errors.UsuarioNoEncontradoException;
import com.example.manejodeerrores.services.UsuarioService;

@Controller
@RequestMapping("/app")
public class AppController {

    @Autowired
    @Qualifier("service")
    private UsuarioService service;

    @GetMapping("/index")
    public String index(Model model){
        // Integer num = 100/0;//Provocamos un error de aritmetica!
        Integer valor = Integer.parseInt("hola");//Provocamos un error de conversion numerica
        return "index";
    }

    @GetMapping("/ver/{id}")
    public String ver(@PathVariable Integer id, Model model){
        // Usuario usuario = service.obtenerPorId(new Usuario(id));
        // if (usuario == null) {
        //     throw new UsuarioNoEncontradoException(id.toString());
        // }

        Usuario usuario = service.obtenerPorIdConOptional(new Usuario(id))
        .orElseThrow(() -> new UsuarioNoEncontradoException(id.toString()));
        
        model.addAttribute("usuario", usuario);
        model.addAttribute("titulo", "Detalle del usuario: "
        .concat(usuario.getNombre()));//Si el id no existe se produce un NullPointerException
        return "ver";
    }
    
}
