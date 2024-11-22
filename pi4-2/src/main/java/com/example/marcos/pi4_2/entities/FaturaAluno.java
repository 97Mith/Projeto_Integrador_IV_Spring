package com.example.marcos.pi4_2.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

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
    private LocalDate vencimento;
    @Column(nullable = false)
    private double valor;
    @ManyToOne
    private ResponsavelAluno responsavelAluno;
    @Column(nullable = false)
    private boolean estaPago;

    public FaturaAluno(LocalDate vencimento, double valor, ResponsavelAluno responsavelAluno, boolean estaPago) {
        this.vencimento = vencimento;
        this.valor = valor;
        this.responsavelAluno = responsavelAluno;
        this.estaPago = estaPago;
    }
}
