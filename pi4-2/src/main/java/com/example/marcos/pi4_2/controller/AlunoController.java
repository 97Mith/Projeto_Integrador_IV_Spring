package com.example.marcos.pi4_2.controller;

import com.example.marcos.pi4_2.entities.Aluno;
import com.example.marcos.pi4_2.services.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping(value = "/alunos")
@RequiredArgsConstructor
public class AlunoController {

    @Autowired
    private final AlunoService alunoService;

    @GetMapping("/cadastrar")
    public String cadastrar(Aluno aluno){
        return "/alunos/cadastro";
    }
    @GetMapping("/listar")
    public String listar(ModelMap model){

        model.addAttribute("alunos", alunoService.findAll());
        return "/alunos/lista";
    }
    @PostMapping("/salvar")
    public String salvar(Aluno aluno){
        aluno.setCargo("Aluno");
        aluno.setEstaAtivo(true);
        alunoService.register(aluno);
        return "redirect:/alunos/cadastrar";
    }

    @GetMapping("/editar/{id}")
    public String preEditarAluno(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("aluno", alunoService.findById(id));
        return "/alunos/cadastro";
    }

    @PostMapping("/editar/{id}")
    public String editarAluno(Aluno aluno, @PathVariable("id") Integer id) {
        aluno.setCargo("Aluno");
        alunoService.update(aluno, id);
        return "redirect:/alunos/listar";
    }

    /*@PostMapping("/deletar/{id}")
    public String deletarAluno(@PathVariable("id") Integer id, @RequestParam("senha") String senha) {
        if (senhaService.verificarSenha(senha)) {  // Valida a senha com o serviço
            alunoService.delete(id);
            return "redirect:/alunos/listar";
        }
        return "redirect:/alunos/listar?error=senha";  // Redireciona com erro
    }*/


}
