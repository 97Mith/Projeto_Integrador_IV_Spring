package com.example.marcos.pi4_2.controller;

import com.example.marcos.pi4_2.entities.Aula;
import com.example.marcos.pi4_2.services.AulaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/")
public class HomeController {
    AulaService aulaService;
    public HomeController(AulaService aulaService) {
        this.aulaService = aulaService;
    }
    @GetMapping({"", "/", "/home"})
    public String home(Model model) {
        List<Aula> aulas = aulaService.findAll()
                .stream()
                .sorted((a1, a2) -> a2.getDataEHoraTreino().compareTo(a1.getDataEHoraTreino()))
                .limit(8) // Limita a 8 aulas
                .collect(Collectors.toList());
        model.addAttribute("aulas", aulas);
        return "home";
    }
}
