package com.example.marcos.pi4_2.services;

import com.example.marcos.pi4_2.entities.FaturaAluno;

import java.util.List;

public interface FaturaAlunoService {
    FaturaAluno findById(Integer id);
    List<FaturaAluno> findAll();
    FaturaAluno register(FaturaAluno aula);
    FaturaAluno update(FaturaAluno aula, Integer id);
    String delete(Integer id);
}
