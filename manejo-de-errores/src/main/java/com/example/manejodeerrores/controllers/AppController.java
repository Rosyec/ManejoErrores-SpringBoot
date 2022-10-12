package com.example.manejodeerrores.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class AppController {

    @GetMapping("/index")
    public String index(Model model){
        // Integer num = 100/0;//Provocamos un error de aritmetica!
        Integer valor = Integer.parseInt("hola");//Provocamos un error de conversion numerica
        return "index";
    }
    
}
