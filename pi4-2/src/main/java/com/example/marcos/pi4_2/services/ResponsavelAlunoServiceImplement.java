package com.example.marcos.pi4_2.services;

import com.example.marcos.pi4_2.entities.ResponsavelAluno;
import com.example.marcos.pi4_2.repositories.ResposavelAlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class ResponsavelAlunoServiceImplement implements ResponsavelAlunoService {

    private final ResposavelAlunoRepository responsavelAlunoRepository;

    @Override
    public ResponsavelAluno findById(Integer id) {
        return returnResponsavelAluno(id);
    }

    @Override
    public List<ResponsavelAluno> findAll() {
        return responsavelAlunoRepository.findAll();
    }

    @Override
    public ResponsavelAluno register(ResponsavelAluno responsavelAluno) {
        return responsavelAlunoRepository.save(responsavelAluno);
    }

    @Override
    public ResponsavelAluno update(ResponsavelAluno responsavelAluno, Integer id) {
        ResponsavelAluno responsavelAlunoToUpdate = returnResponsavelAluno(id);
        updateResponsavelAlunoData(responsavelAlunoToUpdate, responsavelAluno);
        return responsavelAlunoRepository.save(responsavelAlunoToUpdate);
    }

    @Override
    public String delete(Integer id) {
        responsavelAlunoRepository.deleteById(id);
        return "Responsável pelo aluno excluído com sucesso!";
    }

    @Override
    public List<ResponsavelAluno> findByNome(String nome) {
        return responsavelAlunoRepository.findByNome(nome);
    }

    @Override
    public ResponsavelAluno findByCpf(String cpf) {
        return responsavelAlunoRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Responsável não encontrado!"));
    }

    private ResponsavelAluno returnResponsavelAluno(Integer id) {
        return responsavelAlunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Responsável pelo aluno não encontrado no banco de dados"));
    }

    private void updateResponsavelAlunoData(ResponsavelAluno responsavelAlunoToUpdate, ResponsavelAluno responsavelAluno) {
        responsavelAlunoToUpdate.setNome(responsavelAluno.getNome());
        responsavelAlunoToUpdate.setCpf(responsavelAluno.getCpf());
        responsavelAlunoToUpdate.setTel(responsavelAluno.getTel());
        responsavelAlunoToUpdate.setEmail(responsavelAluno.getEmail());
        responsavelAlunoToUpdate.setSenha(responsavelAluno.getSenha());
        responsavelAlunoToUpdate.setCargo(responsavelAluno.getCargo());
        responsavelAlunoToUpdate.setEstaAtivo(responsavelAluno.isEstaAtivo());
        responsavelAlunoToUpdate.setFaturas(responsavelAluno.getFaturas());
        responsavelAlunoToUpdate.setResponsavelPor(responsavelAluno.getResponsavelPor());
    }
}
