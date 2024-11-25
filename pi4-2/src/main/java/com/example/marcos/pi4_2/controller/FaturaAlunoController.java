package com.example.marcos.pi4_2.controller;

import com.example.marcos.pi4_2.entities.FaturaAluno;
import com.example.marcos.pi4_2.services.FaturaAlunoService;
import com.example.marcos.pi4_2.services.ResponsavelAlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/faturas")
@RequiredArgsConstructor
public class FaturaAlunoController {

    private final FaturaAlunoService faturaService;
    private final ResponsavelAlunoService responsavelService;

    @GetMapping("/cadastrar")
    public String cadastrar(ModelMap model) {
        model.addAttribute("fatura", new FaturaAluno());
        model.addAttribute("responsaveis", responsavelService.findAll());
        return "faturas/cadastro";
    }

    @PostMapping("/salvar")
    public String salvar(FaturaAluno faturaAluno) {
        faturaService.register(faturaAluno);
        return "redirect:/faturas/listar";
    }

    // Página de Listagem de Faturas
    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("faturas", faturaService.findAll());
        return "faturas/lista";
    }

    @GetMapping("/editar/{id}")
    public String preEditarFatura(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("fatura", faturaService.findById(id));
        return "/faturas/cadastro";
    }

    @PostMapping("/editar/{id}")
    public String editarFatura(FaturaAluno faturaAluno, @PathVariable("id") Integer id) {
        faturaService.update(faturaAluno, id);
        return "redirect:/faturas/listar";
    }

    @PostMapping("/deletar/{id}")
    public String deletarFatura(@PathVariable("id") Integer id){
        faturaService.delete(id);
        return "redirect:/faturas/listar";
    }
}
