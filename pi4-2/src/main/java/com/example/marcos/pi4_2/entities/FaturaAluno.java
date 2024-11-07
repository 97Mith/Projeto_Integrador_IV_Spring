package com.example.marcos.pi4_2.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tb_faturas")
public class FaturaAluno {
    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = true)
    private Date vencimento;
    @Column(nullable = false)
    private double valor;
    @ManyToOne
    private ResponsavelAluno responsavelAluno;

    public FaturaAluno(Date vencimento, double valor, ResponsavelAluno responsavelAluno) {
        this.vencimento = vencimento;
        this.valor = valor;
        this.responsavelAluno = responsavelAluno;
    }
}
