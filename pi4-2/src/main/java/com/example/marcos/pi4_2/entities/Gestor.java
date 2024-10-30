package com.example.marcos.pi4_2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "tb_gestor")
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
public class Gestor extends Pessoa{


    public Gestor(String nome, String cpf, String tel, String email, String senha, String cargo, boolean estaAtivo) {
        super(nome, cpf, tel, email, senha, cargo, estaAtivo);
    }

}
