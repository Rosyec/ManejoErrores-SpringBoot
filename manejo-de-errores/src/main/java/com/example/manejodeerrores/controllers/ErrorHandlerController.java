package com.example.manejodeerrores.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler({ArithmeticException.class})//Podemos pasar varias excepciones!
    public String aritmeticaError(Exception e, Model model){
        model.addAttribute("error", "Error de aritmetica");
        model.addAttribute("message", e.getMessage());
        model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addAttribute("timestamp", new  Date());
        return "error/aritmetica";
    }
}
