package com.example.marcos.pi4_2.repositories;

import com.example.marcos.pi4_2.entities.ResponsavelAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResposavelAlunoRepository extends JpaRepository<ResponsavelAluno, Integer> {
}
