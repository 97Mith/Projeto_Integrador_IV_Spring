package com.example.marcos.pi4_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String index() {
        return "index"; // Carrega landingage.html de templates
    }

    @GetMapping("/registrar")
    public String registrar() {
        return "registrar"; // Carrega registrar.html de templates
    }

    @GetMapping("/editar")
    public String editar() {
        return "editar"; // Carrega editar.html de templates
    }
}

