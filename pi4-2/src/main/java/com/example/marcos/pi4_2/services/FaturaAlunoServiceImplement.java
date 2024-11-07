package com.example.marcos.pi4_2.services;

import com.example.marcos.pi4_2.entities.FaturaAluno;
import com.example.marcos.pi4_2.repositories.FaturaAlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class FaturaAlunoServiceImplement implements FaturaAlunoService {

    private final FaturaAlunoRepository faturaAlunoRepository;

    @Override
    public FaturaAluno findById(Integer id) {
        return returnFaturaAluno(id);
    }

    @Override
    public List<FaturaAluno> findAll() {
        return faturaAlunoRepository.findAll();
    }

    @Override
    public FaturaAluno register(FaturaAluno faturaAluno) {
        return faturaAlunoRepository.save(faturaAluno);
    }

    @Override
    public FaturaAluno update(FaturaAluno faturaAluno, Integer id) {
        FaturaAluno faturaAlunoToUpdate = returnFaturaAluno(id);
        updateFaturaAlunoData(faturaAlunoToUpdate, faturaAluno);
        return faturaAlunoRepository.save(faturaAlunoToUpdate);
    }

    @Override
    public String delete(Integer id) {
        faturaAlunoRepository.deleteById(id);
        return "Fatura do aluno excluída com sucesso!";
    }

    private FaturaAluno returnFaturaAluno(Integer id) {
        return faturaAlunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fatura do aluno não encontrada no banco de dados"));
    }

    private void updateFaturaAlunoData(FaturaAluno faturaAlunoToUpdate, FaturaAluno faturaAluno) {
        faturaAlunoToUpdate.setVencimento(faturaAluno.getVencimento());
        faturaAlunoToUpdate.setValor(faturaAluno.getValor());
        faturaAlunoToUpdate.setResponsavelAluno(faturaAluno.getResponsavelAluno());
    }
}
