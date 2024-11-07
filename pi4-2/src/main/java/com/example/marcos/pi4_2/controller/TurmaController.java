package com.example.marcos.pi4_2.controller;

import com.example.marcos.pi4_2.entities.Turma;
import com.example.marcos.pi4_2.services.TurmaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/turma")
@RequiredArgsConstructor
public class TurmaController {
    private final TurmaService turmaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Turma> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(turmaService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Turma>> findAll() {
        return ResponseEntity.ok().body(turmaService.findAll());
    }

    @PostMapping
    public ResponseEntity<Turma> register(@RequestBody Turma turma, UriComponentsBuilder uriBuilder) {
        Turma turmaCriada = turmaService.register(turma);
        URI uri = uriBuilder.path("/turma/{id}").buildAndExpand(turmaCriada.getId()).toUri();
        return ResponseEntity.created(uri).body(turmaCriada);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Turma> update(@RequestBody Turma turma, @PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok().body(turmaService.update(turma, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok().body(turmaService.delete(id));
    }
}
