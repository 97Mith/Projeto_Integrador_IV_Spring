package com.example.marcos.pi4_2.services;

import com.example.marcos.pi4_2.entities.ResponsavelAluno;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponsavelAlunoService {
    ResponsavelAluno findById(Integer id);
    List<ResponsavelAluno> findAll();
    ResponsavelAluno register(ResponsavelAluno aula);
    ResponsavelAluno update(ResponsavelAluno aula, Integer id);
    String delete(Integer id);
    List<ResponsavelAluno> findByNome(String nome);
    ResponsavelAluno findByCpf(String cpf);
}
