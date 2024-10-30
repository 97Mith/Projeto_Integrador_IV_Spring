package com.example.marcos.pi4_2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }
}
