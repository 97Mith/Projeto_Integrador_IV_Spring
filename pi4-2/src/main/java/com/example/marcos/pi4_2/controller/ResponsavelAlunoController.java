package com.example.marcos.pi4_2.controller;

import com.example.marcos.pi4_2.entities.Aluno;
import com.example.marcos.pi4_2.entities.ResponsavelAluno;
import com.example.marcos.pi4_2.services.AlunoService;
import com.example.marcos.pi4_2.services.ResponsavelAlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping(value = "/responsaveis")
@RequiredArgsConstructor
public class ResponsavelAlunoController {
    private final ResponsavelAlunoService responsavelService;
    private final AlunoService alunoService;

    @GetMapping("/cadastrar")
    public String cadastrar(ModelMap model) {
        model.addAttribute("alunos", alunoService.findAll());
        model.addAttribute("responsavel", new ResponsavelAluno());
        return "responsaveis/cadastro";
    }

    // Exibe a página de listagem
    @GetMapping("/listar")
    public String listar(ModelMap model) {
        model.addAttribute("responsaveis", responsavelService.findAll());
        return "responsaveis/lista";
    }

    @PostMapping("/salvar")
    public String salvar(@ModelAttribute ResponsavelAluno responsavelAluno, @RequestParam("alunoId") Integer alunoId) {
        Aluno alunoSelecionado = alunoService.findById(alunoId);

        responsavelAluno.setResponsavelPor(Collections.singletonList(alunoSelecionado));
        responsavelAluno.setEstaAtivo(true);
        responsavelAluno.setCargo("Responsável");
        responsavelAluno.setSenha("Responsável");
        responsavelService.register(responsavelAluno);
        return "redirect:/responsaveis/listar";
    }



    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("alunos", alunoService.findAll());
        model.addAttribute("responsavel", responsavelService.findById(id));
        return "responsaveis/cadastro";
    }

    @PostMapping("/editar/{id}")
    public String editar(@PathVariable("id") Integer id, ResponsavelAluno responsavelAluno) {
        responsavelAluno.setCargo("Responsável");
        responsavelAluno.setSenha("Responsável");
        responsavelService.update(responsavelAluno, id);
        return "redirect:/responsaveis/listar";
    }

    @PostMapping("/deletar/{id}")
    public String deletarResponsavel(@PathVariable("id") Integer id){
        responsavelService.delete(id);
        return "redirect:/responsaveis/listar";
    }
}
