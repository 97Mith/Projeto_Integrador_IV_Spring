package com.example.marcos.pi4_2.controller;

import com.example.marcos.pi4_2.dto.request.GestorRequestDTO;
import com.example.marcos.pi4_2.dto.response.GestorResponseDTO;
import com.example.marcos.pi4_2.services.GestorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/gestores")
@RequiredArgsConstructor

public class GestorController {
    public final GestorService gestorService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<GestorResponseDTO> findById(@PathVariable Integer id){
        return ResponseEntity.ok().body(gestorService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<GestorResponseDTO>> findAll(){
        return ResponseEntity.ok().body(gestorService.findAll());
    }

    @PostMapping
    public ResponseEntity<GestorResponseDTO> registrar(@RequestBody GestorRequestDTO gestorDTO, UriComponentsBuilder uriBuilder){

        GestorResponseDTO gestorCriado = gestorService.register(gestorDTO);

        URI uri = uriBuilder.path("/gestores/{id}").buildAndExpand(gestorCriado.getId()).toUri();

        return ResponseEntity.created(uri).body(gestorCriado);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<GestorResponseDTO> atualizar(@RequestBody GestorRequestDTO gestorDTO, @PathVariable(name = "id") Integer id){
        return ResponseEntity.ok().body(gestorService.update(gestorDTO, id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletar(@PathVariable(value = "id") Integer id){
        return ResponseEntity.ok().body(gestorService.delete(id));
    }
}
