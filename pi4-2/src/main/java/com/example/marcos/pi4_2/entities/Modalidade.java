package com.example.marcos.pi4_2.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "tb_modalidade")
public class Modalidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "categoria")
    private String categoria;

    @OneToMany
    @JoinColumn
    private List<Turma> turmas;

    public Modalidade(String nome, String descricao, String categoria, List<Turma> turmas) {
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.turmas = turmas;
    }
}