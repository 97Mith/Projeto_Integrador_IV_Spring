package com.example.marcos.pi4_2.services;

import com.example.marcos.pi4_2.entities.Modalidade;
import com.example.marcos.pi4_2.repositories.ModalidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class ModalidadeServiceImplement implements ModalidadeService {

    private final ModalidadeRepository modalidadeRepository;

    @Override
    public Modalidade findById(Integer id) {
        return returnModalidade(id);
    }

    @Override
    public List<Modalidade> findAll() {
        return modalidadeRepository.findAll();
    }

    @Override
    public Modalidade register(Modalidade modalidade) {
        return modalidadeRepository.save(modalidade);
    }

    @Override
    public Modalidade update(Modalidade modalidade, Integer id) {
        Modalidade modalidadeToUpdate = returnModalidade(id);
        updateModalidadeData(modalidadeToUpdate, modalidade);
        return modalidadeRepository.save(modalidadeToUpdate);
    }

    @Override
    public String delete(Integer id) {
        modalidadeRepository.deleteById(id);
        return "Modalidade excluída com sucesso!";
    }

    @Override
    public List<Modalidade> findByNome(String nome) {
        return modalidadeRepository.findByNome(nome);
    }

    private Modalidade returnModalidade(Integer id) {
        return modalidadeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Modalidade não encontrada no banco de dados"));
    }

    private void updateModalidadeData(Modalidade modalidadeToUpdate, Modalidade modalidade) {
        modalidadeToUpdate.setNome(modalidade.getNome());
        modalidadeToUpdate.setDescricao(modalidade.getDescricao());
        modalidadeToUpdate.setCategoria(modalidade.getCategoria());
        modalidadeToUpdate.setTurmas(modalidade.getTurmas());
    }
}
