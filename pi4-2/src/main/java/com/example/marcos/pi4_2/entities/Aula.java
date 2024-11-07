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
@Table(name = "aula")
public class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @Column(name = "avaliacao_da_aula")
    private double avaliacaoDaAula;

    @OneToMany
    private List<ComentarioAula> comentarioAulas;

    @OneToMany
    @JoinColumn(name = "alunos_presentes_id")
    private List<FichaAluno> presentes;

    public Aula(Professor professor, double avaliacaoDaAula, List<ComentarioAula> comentarioAulas, List<FichaAluno> presentes) {
        this.professor = professor;
        this.avaliacaoDaAula = avaliacaoDaAula;
        this.comentarioAulas = comentarioAulas;
        this.presentes = presentes;
    }
}