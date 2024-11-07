package com.example.marcos.pi4_2.services;

import com.example.marcos.pi4_2.entities.ComentarioAula;
import com.example.marcos.pi4_2.repositories.ComentarioAulaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class ComentarioAulaServiceImplement implements ComentarioAulaService {

    private final ComentarioAulaRepository comentarioAulaRepository;

    @Override
    public ComentarioAula findById(Integer id) {
        return returnComentarioAula(id);
    }

    @Override
    public List<ComentarioAula> findAll() {
        return comentarioAulaRepository.findAll();
    }

    @Override
    public ComentarioAula register(ComentarioAula comentarioAula) {
        return comentarioAulaRepository.save(comentarioAula);
    }

    @Override
    public ComentarioAula update(ComentarioAula comentarioAula, Integer id) {
        ComentarioAula comentarioAulaToUpdate = returnComentarioAula(id);
        updateComentarioAulaData(comentarioAulaToUpdate, comentarioAula);
        return comentarioAulaRepository.save(comentarioAulaToUpdate);
    }

    @Override
    public String delete(Integer id) {
        comentarioAulaRepository.deleteById(id);
        return "Comentário da aula excluído com sucesso!";
    }

    private ComentarioAula returnComentarioAula(Integer id) {
        return comentarioAulaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentário da aula não encontrado no banco de dados"));
    }

    private void updateComentarioAulaData(ComentarioAula comentarioAulaToUpdate, ComentarioAula comentarioAula) {
        comentarioAulaToUpdate.setComentario(comentarioAula.getComentario());
        comentarioAulaToUpdate.setAvaliacao(comentarioAula.getAvaliacao());
        comentarioAulaToUpdate.setAula(comentarioAula.getAula());
    }
}
