package com.example.marcos.pi4_2.controller;

import com.example.marcos.pi4_2.entities.ResponsavelAluno;
import com.example.marcos.pi4_2.services.ResponsavelAlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/responsavel-aluno")
@RequiredArgsConstructor
public class ResponsavelAlunoController {
    private final ResponsavelAlunoService responsavelService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponsavelAluno> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(responsavelService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<ResponsavelAluno>> findAll() {
        return ResponseEntity.ok().body(responsavelService.findAll());
    }
    @GetMapping(value = "/nome/{nome}")
    public ResponseEntity<List<ResponsavelAluno>> findByNome(@PathVariable String nome) {
        return ResponseEntity.ok().body(responsavelService.findByNome(nome));
    }
    @GetMapping(value = "/cpf/{cpf}")
    public ResponseEntity<ResponsavelAluno> findByCpf(@PathVariable String cpf) {
        return ResponseEntity.ok().body(responsavelService.findByCpf(cpf));
    }

    @PostMapping
    public ResponseEntity<ResponsavelAluno> register(@RequestBody ResponsavelAluno reponsavel, UriComponentsBuilder uriBuilder) {
        ResponsavelAluno responsavelAluno = responsavelService.register(reponsavel);
        URI uri = uriBuilder.path("/responsavel-aluno/{id}").buildAndExpand(responsavelAluno.getId()).toUri();
        return ResponseEntity.created(uri).body(responsavelAluno);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ResponsavelAluno> update(@RequestBody ResponsavelAluno responsavelAluno, @PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok().body(responsavelService.update(responsavelAluno, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok().body(responsavelService.delete(id));
    }
}
