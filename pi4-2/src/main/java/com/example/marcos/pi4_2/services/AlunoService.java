package com.example.marcos.pi4_2.services;

import com.example.marcos.pi4_2.entities.Aluno;

import java.util.List;

public interface AlunoService {
    Aluno findById(Integer id);
    List<Aluno> findAll();
    Aluno register(Aluno aluno);
    Aluno update(Aluno aluno, Integer id);
    String delete(Integer id);
    List<Aluno> findByNome(String nome);
    Aluno findByCpf(String cpf);
}
