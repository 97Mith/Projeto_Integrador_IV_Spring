package com.example.marcos.pi4_2.controller;


import com.example.marcos.pi4_2.entities.Professor;
import com.example.marcos.pi4_2.services.ProfessorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/professor")
@RequiredArgsConstructor
public class ProfessorController {
    private final ProfessorService professorService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Professor> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(professorService.findById(id));
    }
    @GetMapping(value = "nome/{nome}")
    public ResponseEntity<List<Professor>> findByNome(@PathVariable String nome) {
        return ResponseEntity.ok().body(professorService.findByNome(nome));
    }
    @GetMapping(value = "cpf/{cpf}")
    public ResponseEntity<Professor> findByCpf(@PathVariable String cpf) {
        return ResponseEntity.ok().body(professorService.findByCpf(cpf));
    }

    @GetMapping
    public ResponseEntity<List<Professor>> findAll() {
        return ResponseEntity.ok().body(professorService.findAll());
    }

    @PostMapping
    public ResponseEntity<Professor> register(@RequestBody Professor professor, UriComponentsBuilder uriBuilder) {
        Professor professorCriado = professorService.register(professor);
        URI uri = uriBuilder.path("/professor/{id}").buildAndExpand(professorCriado.getId()).toUri();
        return ResponseEntity.created(uri).body(professorCriado);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Professor> update(@RequestBody Professor professor, @PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok().body(professorService.update(professor, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok().body(professorService.delete(id));
    }
}
