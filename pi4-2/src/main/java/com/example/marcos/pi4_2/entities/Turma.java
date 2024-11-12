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
@Table(name = "tb_turma")
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;

    @ManyToOne
    private Modalidade modalidade;

    @Column(name = "hora_do_treino")
    private Date horarioTreino;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @OneToMany
    private List<FichaAluno> alunos;

    @OneToMany
    @JoinColumn(name = "aulas_ids")
    private List<Aula> aulas;

    public Turma(Modalidade modalidade, Date horarioTreino, Professor professor, List<FichaAluno> alunos, List<Aula> aulas) {
        this.modalidade = modalidade;
        this.horarioTreino = horarioTreino;
        this.professor = professor;
        this.alunos = alunos;
        this.aulas = aulas;
    }
}