package com.example.marcos.pi4_2.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "ficha_aluno")
public class FichaAluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(nullable = true)
    private double nota;

    @Column(name = "observacoes", nullable = true)
    private String obs;

    @ManyToOne
    @JoinColumn(name = "turma")
    private Turma turma;
}