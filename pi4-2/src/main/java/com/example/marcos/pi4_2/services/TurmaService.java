package com.example.marcos.pi4_2.services;

import com.example.marcos.pi4_2.entities.Turma;

import java.util.List;

public interface TurmaService {
    Turma findById(Integer id);
    List<Turma> findAll();
    Turma register(Turma aula);
    Turma update(Turma aula, Integer id);
    String delete(Integer id);
}
