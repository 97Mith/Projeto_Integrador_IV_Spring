package com.example.marcos.pi4_2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Table(name = "tb_professores")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Professor extends Pessoa{
    @OneToMany
    private List<Turma> turmas;

    @Column(name = "numero_da_licenca")
    private String licenca;

    @OneToMany
    private List<Aula> aulas;

    public Professor(String nome, String cpf, String tel, String email, String senha, String cargo, boolean estaAtivo,
                     List<Turma> turmas, String licenca, List<Aula> aulas) {
        super(nome, cpf, tel, email, senha, cargo, estaAtivo);  // Chama o construtor de Pessoa
        this.turmas = turmas;
        this.licenca = licenca;
        this.aulas = aulas;
    }
}
