package com.example.marcos.pi4_2.controller;

import com.example.marcos.pi4_2.services.AulaService;
import com.example.marcos.pi4_2.entities.Aula;
import com.example.marcos.pi4_2.services.FaturaAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/aluno-home")
public class AreaAlunoController {

    private final AulaService aulaService;
    private final FaturaAlunoService faturaAlunoService;

    @Autowired
    public AreaAlunoController(AulaService aulaService, FaturaAlunoService faturaAlunoService) {
        this.aulaService = aulaService;
        this.faturaAlunoService = faturaAlunoService;
    }

    @GetMapping("/feed")
    public String home(Model model) {
        List<Aula> aulas = aulaService.findAll();
        model.addAttribute("aulas", aulas);
        return "areaaluno/alunohome";  // Retorna o template correto
    }

    @GetMapping("/minhas-faturas")
    public String minhasFaturas(ModelMap model){
        model.addAttribute("faturas", faturaAlunoService.findAll());
        return "/areaaluno/listafaturas";
    }
}
