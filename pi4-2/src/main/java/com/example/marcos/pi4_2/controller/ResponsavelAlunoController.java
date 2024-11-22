package com.example.marcos.pi4_2.controller;

import com.example.marcos.pi4_2.entities.ResponsavelAluno;
import com.example.marcos.pi4_2.services.ResponsavelAlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/responsaveis")
@RequiredArgsConstructor
public class ResponsavelAlunoController {
    private final ResponsavelAlunoService responsavelService;

    @GetMapping("/cadastrar")
    public String cadastrar(ModelMap model) {
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
    public String salvar(ResponsavelAluno responsavelAluno) {
        responsavelAluno.setCargo("Responsável");
        responsavelAluno.setEstaAtivo(true);
        responsavelService.register(responsavelAluno);
        return "redirect:/responsaveis/listar";
    }

    @GetMapping("/editar/{id}")
    public String preEditar(@PathVariable("id") Integer id, ModelMap model) {
        model.addAttribute("responsavel", responsavelService.findById(id));
        return "responsaveis/cadastro";
    }

    @PostMapping("/editar")
    public String editar(ResponsavelAluno responsavelAluno) {
        responsavelService.update(responsavelAluno);
        return "redirect:/responsaveis/listar";
    }
}
