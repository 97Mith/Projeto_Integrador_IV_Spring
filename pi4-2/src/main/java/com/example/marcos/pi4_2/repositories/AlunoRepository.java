package com.example.marcos.pi4_2.repositories;

import com.example.marcos.pi4_2.entities.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    List<Aluno> findByNome(String nome);
    Optional<Aluno> findByCpf(String cpf);
}
