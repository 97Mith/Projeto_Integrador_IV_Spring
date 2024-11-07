package com.example.marcos.pi4_2.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "comentario_aula")
public class ComentarioAula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    @ManyToOne
    private Aluno aluno;

    private String comentario;

    @ManyToOne
    @JoinColumn(name = "aula_id")
    private Aula aula;

    @Column(name = "estrelas")
    private int avaliacao;
}