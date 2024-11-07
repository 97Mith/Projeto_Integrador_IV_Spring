package com.example.marcos.pi4_2.services;


import com.example.marcos.pi4_2.entities.ComentarioAula;

import java.util.List;

public interface ComentarioAulaService {
    ComentarioAula findById(Integer id);
    List<ComentarioAula> findAll();
    ComentarioAula register(ComentarioAula aula);
    ComentarioAula update(ComentarioAula aula, Integer id);
    String delete(Integer id);
}
