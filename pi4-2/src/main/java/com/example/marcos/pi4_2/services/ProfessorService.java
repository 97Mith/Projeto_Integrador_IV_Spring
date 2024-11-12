package com.example.marcos.pi4_2.services;

import com.example.marcos.pi4_2.entities.Professor;

import java.util.List;

public interface ProfessorService {
    Professor findById(Integer id);
    List<Professor> findAll();
    Professor register(Professor aula);
    Professor update(Professor aula, Integer id);
    String delete(Integer id);
    List<Professor> findByNome(String nome);
    Professor findByCpf(String cpf);
}
