package com.example.marcos.pi4_2.controller;

import com.example.marcos.pi4_2.entities.FichaAluno;
import com.example.marcos.pi4_2.services.FichaAlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/ficha-aluno")
@RequiredArgsConstructor
public class FichaAlunoController {
    private final FichaAlunoService fichaAlunoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<FichaAluno> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(fichaAlunoService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<FichaAluno>> findAll(){
        return ResponseEntity.ok().body(fichaAlunoService.findAll());
    }

    @PostMapping
    public ResponseEntity<FichaAluno> register(@RequestBody FichaAluno fichaAluno, UriComponentsBuilder uriBuilder){
        FichaAluno fichaCriada = fichaAlunoService.register(fichaAluno);
        URI uri = uriBuilder.path("/ficha-aluno/{id}").buildAndExpand(fichaCriada.getId()).toUri();
        return ResponseEntity.created(uri).body(fichaCriada);
    }

    @PutMapping
    public ResponseEntity<FichaAluno> update(@RequestBody FichaAluno fichaAluno, @PathVariable(name = "id") Integer id){
        return ResponseEntity.ok().body(fichaAlunoService.update(fichaAluno, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Integer id){
        return ResponseEntity.ok().body(fichaAlunoService.delete(id));
    }
}
