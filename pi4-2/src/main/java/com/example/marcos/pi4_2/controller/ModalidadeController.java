package com.example.marcos.pi4_2.controller;

import com.example.marcos.pi4_2.entities.Modalidade;
import com.example.marcos.pi4_2.services.ModalidadeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/modalidades")
@RequiredArgsConstructor
public class ModalidadeController {

    private final ModalidadeService modalidadeService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Modalidade> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(modalidadeService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<Modalidade>> findAll() {
        return ResponseEntity.ok().body(modalidadeService.findAll());
    }

    @PostMapping
    public ResponseEntity<Modalidade> register(@RequestBody Modalidade modalidade, UriComponentsBuilder uriBuilder) {
        Modalidade modalidadeCriada = modalidadeService.register(modalidade);
        URI uri = uriBuilder.path("/modalidades/{id}").buildAndExpand(modalidadeCriada.getId()).toUri();
        return ResponseEntity.created(uri).body(modalidadeCriada);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Modalidade> update(@RequestBody Modalidade modalidade, @PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok().body(modalidadeService.update(modalidade, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok().body(modalidadeService.delete(id));
    }
}
