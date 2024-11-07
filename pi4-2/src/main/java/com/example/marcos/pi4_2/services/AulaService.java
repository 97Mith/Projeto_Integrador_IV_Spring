package com.example.marcos.pi4_2.services;

import com.example.marcos.pi4_2.entities.Aula;

import java.util.List;

public interface AulaService {
    Aula findById(Integer id);
    List<Aula> findAll();
    Aula register(Aula aula);
    Aula update(Aula aula, Integer id);
    String delete(Integer id);
}
