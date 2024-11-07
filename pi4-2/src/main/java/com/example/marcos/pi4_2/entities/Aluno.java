package com.example.marcos.pi4_2.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@SuperBuilder
@Table(name = "aluno")
public class Aluno extends Pessoa{
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

    public Aluno(String nome, String cpf, String tel, String email, String senha, String cargo, boolean estaAtivo,
                 Date dataNasc, Integer rating, List<FichaAluno> fichasAluno, List<ComentarioAula> historicoComentarios) {
        super(nome, cpf, tel, email, senha, cargo, estaAtivo);
        this.dataNasc = dataNasc;
        this.rating = rating;
        this.fichasAluno = fichasAluno;
        this.historicoComentarios = historicoComentarios;
    }
}