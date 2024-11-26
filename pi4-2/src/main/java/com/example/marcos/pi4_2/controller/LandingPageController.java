package com.example.marcos.pi4_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingPageController {

    @GetMapping("/landing-page")
    public String showLandingPage() {
        return "landingpage/index";
    }

    // Adicione métodos para outras páginas
    @GetMapping("/lista-esportes")
    public String showListaEsportes() {
        return "landingpage/listaEsportes";
    }

    @GetMapping("/visita")
    public String showVisita() {
        return "landingpage/visita";
    }

    @GetMapping("/sobre-nos")
    public String showSobreNos() {
        return "landingpage/sobreNos";
    }

    @GetMapping("/comentario")
    public String showComentario() {
        return "landingpage/comentario";
    }

    @GetMapping("/sobre-esportes")
    public String showSobreEsportes() {
        return "landingpage/sobreEsportes";
    }

    @GetMapping("/login")
    public String showLogin() {
        return "login";
    }
}
