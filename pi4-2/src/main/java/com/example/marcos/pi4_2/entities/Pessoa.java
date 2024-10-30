package com.example.marcos.pi4_2.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "tb_pessoas")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(name = "nome_da_pessoa", nullable = false)
    private String nome;

    @Column(name = "CPF", nullable = false)
    private String cpf;

    @Column(name = "telefone")
    private String tel;

    @Column(name = "email_ou_login", nullable = false)
    private String email;

    @Column(name = "senha_usuario", nullable = false)
    private String senha;

    @Column(name = "cargo_ou_funcao", nullable = false)
    private String cargo;
    @Column(name = "esta_ativo")
    private boolean estaAtivo;


    public Pessoa(String nome, String cpf, String tel, String email, String senha, String cargo, boolean estaAtivo) {
        this.nome = nome;
        this.cpf = cpf;
        this.tel = tel;
        this.email = email;
        this.senha = senha;
        this.cargo = cargo;
        this.estaAtivo = estaAtivo;
    }
}
