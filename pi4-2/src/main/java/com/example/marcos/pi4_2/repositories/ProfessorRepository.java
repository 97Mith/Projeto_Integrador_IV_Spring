package com.example.marcos.pi4_2.repositories;

import com.example.marcos.pi4_2.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
    List<Professor> findByNome(String nome);
    Optional<Professor> findByCpf(String cpf);
}
