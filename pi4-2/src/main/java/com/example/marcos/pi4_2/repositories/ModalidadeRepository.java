package com.example.marcos.pi4_2.repositories;

import com.example.marcos.pi4_2.entities.Modalidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModalidadeRepository extends JpaRepository<Modalidade, Integer> {
    List<Modalidade> findByNome(String nome);
}
