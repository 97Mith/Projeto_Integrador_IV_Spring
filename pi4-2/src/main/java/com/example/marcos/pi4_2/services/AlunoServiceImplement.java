package com.example.marcos.pi4_2.services;

import com.example.marcos.pi4_2.entities.Aluno;
import com.example.marcos.pi4_2.repositories.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class AlunoServiceImplement implements AlunoService{
    private  final AlunoRepository alunoRepository;
    @Override
    public Aluno findById(Integer id) {
        return returnAluno(id);
    }

    @Override
    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno register(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public Aluno update(Aluno aluno, Integer id){
        Aluno aluno4Updated = returnAluno(id);

        updateAlunoData(aluno4Updated, aluno);

        return alunoRepository.save(aluno4Updated);
    }

    @Override
    public String delete(Integer id){
        alunoRepository.deleteById(id);

        return "Alunoexcluído com sucesso!";
    }

    @Override
    public List<Aluno> findByNome(String nome) {
        return alunoRepository.findByNome(nome);
    }

    @Override
    public Aluno findByCpf(String cpf) {
        return alunoRepository.findByCpf(cpf)
                .orElseThrow(() -> new RuntimeException("Aluno com CPF " + cpf + " não encontrado"));
    }

    private Aluno returnAluno(Integer id){
        return alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não encontrado no banco de dados"));
    }

    private void updateAlunoData(Aluno aluno4Update, Aluno aluno){

        aluno4Update.setNome(aluno.getNome());
        aluno4Update.setCpf(aluno.getCpf());
        aluno4Update.setTel(aluno.getTel());
        aluno4Update.setEmail(aluno.getEmail());
        aluno4Update.setSenha(aluno.getSenha());
        aluno4Update.setCargo(aluno.getCargo());
        aluno4Update.setEstaAtivo(aluno.isEstaAtivo());
        aluno4Update.setDataNasc(aluno.getDataNasc());
        aluno4Update.setRating(aluno.getRating());
        aluno4Update.setFichasAluno(aluno.getFichasAluno());
        aluno4Update.setHistoricoComentarios(aluno.getHistoricoComentarios());

    }

}
