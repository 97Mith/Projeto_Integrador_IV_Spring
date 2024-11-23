package com.example.marcos.pi4_2.controller;


import com.example.marcos.pi4_2.entities.Professor;
import com.example.marcos.pi4_2.services.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping(value = "/professores")
@RequiredArgsConstructor
public class ProfessorController {
    private final ProfessorService professorService;

    //-----------------------------------------------
    @GetMapping("/cadastrar")
    public String cadastrar(Model model) {
        model.addAttribute("professor",new Professor());
        model.addAttribute("professores", professorService.findAll());
        return "/professores/cadastro";
    }
    @GetMapping("/listar")
    public String listar(Model model) {
        List<Professor> professores = professorService.findAll();
        model.addAttribute("professores", professores);
        return "/professores/lista";
    }
    @PostMapping("/salvar")
    public String salvar(Professor professor){
        professor.setCargo("Professor");
        professorService.register(professor);
        return "redirect:/professores/listar";
    }

    @GetMapping("/editar/{id}")
    public String preEditarProfessor(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("professor", professorService.findById(id));
        return "/professores/cadastro";
    }

    @PostMapping("/editar/{id}")
    public String editarProfessor(Professor professor, @PathVariable("id") Integer id) {
        professor.setCargo("Professor");
        professorService.update(professor, id);
        return "redirect:/professores/listar";
    }

    @PostMapping("/deletar/{id}")
    public String deletarProfessor(@PathVariable("id") Integer id) {
        professorService.delete(id);
        return "redirect:/professores/listar";
    }
}
