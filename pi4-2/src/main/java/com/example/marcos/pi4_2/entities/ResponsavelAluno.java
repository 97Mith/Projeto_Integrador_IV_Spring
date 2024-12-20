package com.example.marcos.pi4_2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tb_responsavel_aluno")
public class ResponsavelAluno extends Pessoa {
    @OneToMany
    @JoinColumn(name = "faturas")
    private List<FaturaAluno> faturas;

    @OneToMany
    @JoinColumn(name = "responsavel_aluno_id")
    private List<Aluno> responsavelPor;

    public ResponsavelAluno(String nome, String cpf, String tel, String email, String senha, String cargo, boolean estaAtivo,
                            List<FaturaAluno> faturas, List<Aluno> responsavelPor) {
        super(nome, cpf, tel, email, senha, cargo, estaAtivo);  // Chama o construtor de Pessoa
        this.faturas = faturas;
        this.responsavelPor = responsavelPor;
    }
}