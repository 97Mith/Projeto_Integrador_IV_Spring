package com.example.marcos.pi4_2.controller;

import com.example.marcos.pi4_2.entities.FaturaAluno;
import com.example.marcos.pi4_2.services.FaturaAlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/faturas-aluno")
@RequiredArgsConstructor
public class FaturaAlunoController {

    private final FaturaAlunoService faturaAlunoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<FaturaAluno> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(faturaAlunoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<FaturaAluno>> findAll() {
        return ResponseEntity.ok().body(faturaAlunoService.findAll());
    }

    @PostMapping
    public ResponseEntity<FaturaAluno> register(@RequestBody FaturaAluno faturaAluno, UriComponentsBuilder uriBuilder) {
        FaturaAluno faturaCriada = faturaAlunoService.register(faturaAluno);
        URI uri = uriBuilder.path("/faturas-aluno/{id}").buildAndExpand(faturaCriada.getId()).toUri();
        return ResponseEntity.created(uri).body(faturaCriada);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<FaturaAluno> update(@RequestBody FaturaAluno faturaAluno, @PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok().body(faturaAlunoService.update(faturaAluno, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok().body(faturaAlunoService.delete(id));
    }
}
