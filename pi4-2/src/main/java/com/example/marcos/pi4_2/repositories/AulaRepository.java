package com.example.marcos.pi4_2.repositories;

import com.example.marcos.pi4_2.entities.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Integer> {
}
