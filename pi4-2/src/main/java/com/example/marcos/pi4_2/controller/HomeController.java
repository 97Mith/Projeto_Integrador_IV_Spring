package com.example.marcos.pi4_2.controller;

import com.example.marcos.pi4_2.entities.Aula;
import com.example.marcos.pi4_2.services.AulaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    AulaService aulaService;
    public HomeController(AulaService aulaService) {
        this.aulaService = aulaService;
    }
    @GetMapping({"", "/", "/home"})
    public String home(Model model) {
        List<Aula> aulas = aulaService.findAll();
        model.addAttribute("aulas", aulas);
        return "home";
    }
}
