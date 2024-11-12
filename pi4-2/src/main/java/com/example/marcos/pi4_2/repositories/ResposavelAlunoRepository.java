package com.example.marcos.pi4_2.repositories;

import com.example.marcos.pi4_2.entities.ResponsavelAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResposavelAlunoRepository extends JpaRepository<ResponsavelAluno, Integer> {
    List<ResponsavelAluno> findByNome(String nome);
    Optional<ResponsavelAluno> findByCpf(String cpf);
}
