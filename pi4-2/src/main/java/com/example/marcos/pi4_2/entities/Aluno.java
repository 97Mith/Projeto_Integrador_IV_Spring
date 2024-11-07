package com.example.marcos.pi4_2.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "aluno")
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(name = "data_de_nascimento", nullable = false)
    private Date dataNasc;

    @Column(name = "pontuacao")
    private Integer rating;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "modalidades")
    private List<FichaAluno> fichasAluno;

    @OneToMany//(cascade = CascadeType.ALL)
    @Column(name = "historico_de_comentarios")
    private List<ComentarioAula> historicoComentarios;

}