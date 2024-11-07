package com.example.marcos.pi4_2.services;

import com.example.marcos.pi4_2.entities.Turma;
import com.example.marcos.pi4_2.repositories.TurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class TurmaServiceImplement implements TurmaService {

    private final TurmaRepository turmaRepository;

    @Override
    public Turma findById(Integer id) {
        return returnTurma(id);
    }

    @Override
    public List<Turma> findAll() {
        return turmaRepository.findAll();
    }

    @Override
    public Turma register(Turma turma) {
        return turmaRepository.save(turma);
    }

    @Override
    public Turma update(Turma turma, Integer id) {
        Turma turmaToUpdate = returnTurma(id);
        updateTurmaData(turmaToUpdate, turma);
        return turmaRepository.save(turmaToUpdate);
    }

    @Override
    public String delete(Integer id) {
        turmaRepository.deleteById(id);
        return "Turma excluída com sucesso!";
    }

    private Turma returnTurma(Integer id) {
        return turmaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada no banco de dados"));
    }

    private void updateTurmaData(Turma turmaToUpdate, Turma turma) {
        turmaToUpdate.setModalidade(turma.getModalidade());
        turmaToUpdate.setHorarioTreino(turma.getHorarioTreino());
        turmaToUpdate.setProfessor(turma.getProfessor());
        turmaToUpdate.setAlunos(turma.getAlunos());
        turmaToUpdate.setAulas(turma.getAulas());
    }
}
