package com.example.marcos.pi4_2.services;

import com.example.marcos.pi4_2.entities.FichaAluno;
import com.example.marcos.pi4_2.repositories.FichaAlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class FichaAlunoServiceImplement implements FichaAlunoService {

    private final FichaAlunoRepository fichaAlunoRepository;

    @Override
    public FichaAluno findById(Integer id) {
        return returnFichaAluno(id);
    }

    @Override
    public List<FichaAluno> findAll() {
        return fichaAlunoRepository.findAll();
    }

    @Override
    public FichaAluno register(FichaAluno fichaAluno) {
        return fichaAlunoRepository.save(fichaAluno);
    }

    @Override
    public FichaAluno update(FichaAluno fichaAluno, Integer id) {
        FichaAluno fichaAlunoToUpdate = returnFichaAluno(id);
        updateFichaAlunoData(fichaAlunoToUpdate, fichaAluno);
        return fichaAlunoRepository.save(fichaAlunoToUpdate);
    }

    @Override
    public String delete(Integer id) {
        fichaAlunoRepository.deleteById(id);
        return "Ficha do aluno excluída com sucesso!";
    }

    private FichaAluno returnFichaAluno(Integer id) {
        return fichaAlunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ficha do aluno não encontrada no banco de dados"));
    }

    private void updateFichaAlunoData(FichaAluno fichaAlunoToUpdate, FichaAluno fichaAluno) {
        fichaAlunoToUpdate.setNota(fichaAluno.getNota());
        fichaAlunoToUpdate.setObs(fichaAluno.getObs());
        fichaAlunoToUpdate.setTurma(fichaAluno.getTurma());
    }
}
