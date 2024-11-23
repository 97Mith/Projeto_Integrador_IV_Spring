package com.example.marcos.pi4_2.controller;

import com.example.marcos.pi4_2.entities.Aula;
import com.example.marcos.pi4_2.services.AulaService;
import com.example.marcos.pi4_2.services.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping(value = "/aulas")
@RequiredArgsConstructor
public class AulaController {

    private final AulaService aulaService;
    private final ProfessorService professorService;
    //-----------------------------------------------
    @GetMapping("/cadastrar")
    public String cadastrar(Model model){
        model.addAttribute("aula", new Aula());
        model.addAttribute("professores", professorService.findAll());
        return "/aulas/cadastro";
    }
    @GetMapping("/listar")
    public String listar(Model model) {
        List<Aula> aulas = aulaService.findAll();
        model.addAttribute("aulas", aulas);
        return "/aulas/lista";
    }
    @PostMapping("/salvar")
    public String salvar(Aula aula){
        aulaService.register(aula);
        return "redirect:/";
    }
    @PostMapping("/deletar/{id}")
    public String deletarAula(@PathVariable("id") Integer id) {
        aulaService.delete(id);
        return "redirect:/aulas/listar";
    }

    //------------------------------------------------

    @GetMapping(value = "/{id}")
    public ResponseEntity<Aula> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(aulaService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Aula>> findAll() {
        return ResponseEntity.ok().body(aulaService.findAll());
    }

    @PostMapping
    public ResponseEntity<Aula> register(@RequestBody Aula aula, UriComponentsBuilder uriBuilder) {
        Aula aulaCriada = aulaService.register(aula);
        URI uri = uriBuilder.path("/aulas/{id}").buildAndExpand(aulaCriada.getId()).toUri();
        return ResponseEntity.created(uri).body(aulaCriada);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Aula> update(@RequestBody Aula aula, @PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok().body(aulaService.update(aula, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok().body(aulaService.delete(id));
    }
}
