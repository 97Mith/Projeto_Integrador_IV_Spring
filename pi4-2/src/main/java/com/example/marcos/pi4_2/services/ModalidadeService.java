package com.example.marcos.pi4_2.services;


import com.example.marcos.pi4_2.entities.Modalidade;

import java.util.List;

public interface ModalidadeService {
    Modalidade findById(Integer id);
    List<Modalidade> findAll();
    Modalidade register(Modalidade aula);
    Modalidade update(Modalidade aula, Integer id);
    String delete(Integer id);
    List<Modalidade> findByNome(String nome);
}
