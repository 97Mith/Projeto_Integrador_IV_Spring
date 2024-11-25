package com.example.marcos.pi4_2.controller;

import com.example.marcos.pi4_2.services.AulaService;
import com.example.marcos.pi4_2.entities.Aula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/aluno-home")
public class AreaAlunoController {

    private final AulaService aulaService;

    @Autowired
    public AreaAlunoController(AulaService aulaService) {
        this.aulaService = aulaService;
    }

    @GetMapping("/feed")
    public String home(Model model) {
        List<Aula> aulas = aulaService.findAll();
        model.addAttribute("aulas", aulas);
        return "areaaluno/alunohome";  // Retorna o template correto
    }
}
