package com.example.marcos.pi4_2.controller;

import com.example.marcos.pi4_2.entities.ComentarioAula;
import com.example.marcos.pi4_2.services.ComentarioAulaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/comentarios-aula")
@RequiredArgsConstructor
public class ComentarioAulaController {

    private final ComentarioAulaService comentarioAulaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ComentarioAula> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(comentarioAulaService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ComentarioAula>> findAll() {
        return ResponseEntity.ok().body(comentarioAulaService.findAll());
    }

    @PostMapping
    public ResponseEntity<ComentarioAula> register(@RequestBody ComentarioAula comentarioAula, UriComponentsBuilder uriBuilder) {
        ComentarioAula comentarioCriado = comentarioAulaService.register(comentarioAula);
        URI uri = uriBuilder.path("/comentarios-aula/{id}").buildAndExpand(comentarioCriado.getId()).toUri();
        return ResponseEntity.created(uri).body(comentarioCriado);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ComentarioAula> update(@RequestBody ComentarioAula comentarioAula, @PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok().body(comentarioAulaService.update(comentarioAula, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok().body(comentarioAulaService.delete(id));
    }
}
