package com.example.marcos.pi4_2.services;


import com.example.marcos.pi4_2.entities.FichaAluno;

import java.util.List;

public interface FichaAlunoService {
    FichaAluno findById(Integer id);
    List<FichaAluno> findAll();
    FichaAluno register(FichaAluno aula);
    FichaAluno update(FichaAluno aula, Integer id);
    String delete(Integer id);
}
