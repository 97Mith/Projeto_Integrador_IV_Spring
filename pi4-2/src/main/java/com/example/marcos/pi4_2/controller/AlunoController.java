package com.example.marcos.pi4_2.controller;

import com.example.marcos.pi4_2.entities.Aluno;
import com.example.marcos.pi4_2.services.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Aluno> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(alunoService.findById(id));
    }
    @GetMapping(value = "nome/{nome}")
    public ResponseEntity<List<Aluno>> findByName(@PathVariable String nome) {
        return ResponseEntity.ok().body(alunoService.findByNome(nome));
    }

    @GetMapping(value = "cpf/{cpf}")
    public ResponseEntity<Aluno> findByCpf(@PathVariable String cpf) {
        return ResponseEntity.ok().body(alunoService.findByCpf(cpf));
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> findAll() {
        return ResponseEntity.ok().body(alunoService.findAll());
    }

    @PostMapping
    public ResponseEntity<Aluno> register(@RequestBody Aluno aluno, UriComponentsBuilder uriBuilder) {
        Aluno alunoCriado = alunoService.register(aluno);
        URI uri = uriBuilder.path("/alunos/{id}").buildAndExpand(alunoCriado.getId()).toUri();
        return ResponseEntity.created(uri).body(alunoCriado);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Aluno> update(@RequestBody Aluno aluno, @PathVariable(name = "id") Integer id) {
        return ResponseEntity.ok().body(alunoService.update(aluno, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable(value = "id") Integer id) {
        return ResponseEntity.ok().body(alunoService.delete(id));
    }
}
