package com.example.marcos.pi4_2.services;

import com.example.marcos.pi4_2.entities.Aula;
import com.example.marcos.pi4_2.entities.ComentarioAula;
import com.example.marcos.pi4_2.repositories.AulaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class AulaServiceImplement implements AulaService {

    private final AulaRepository aulaRepository;

    @Override
    public Aula findById(Integer id) {

        Aula aula = returnAula(id);
        atualizarAvaliacaoMedia(aula);
        return aula;
    }

    @Override
    public List<Aula> findAll() {
        List<Aula> aulas = aulaRepository.findAll();
        aulas.forEach(this::atualizarAvaliacaoMedia);
        return aulas;
    }


    @Override
    public Aula register(Aula aula) {
        return aulaRepository.save(aula);
    }

    @Override
    public Aula update(Aula aula, Integer id) {
        Aula aulaToUpdate = returnAula(id);
        updateAulaData(aulaToUpdate, aula);
        return aulaRepository.save(aulaToUpdate);
    }

    @Override
    public String delete(Integer id) {
        aulaRepository.deleteById(id);
        return "Aula excluída com sucesso!";
    }



    private Aula returnAula(Integer id) {
        return aulaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aula não encontrada no banco de dados"));
    }

    private void updateAulaData(Aula aulaToUpdate, Aula aula) {
        aulaToUpdate.setProfessor(aula.getProfessor());
        aulaToUpdate.setAvaliacaoDaAula(aula.getAvaliacaoDaAula());
        aulaToUpdate.setComentarioAulas(aula.getComentarioAulas());
        aulaToUpdate.setPresentes(aula.getPresentes());
    }

    public void atualizarAvaliacaoMedia(Aula aula) {
        List<ComentarioAula> comentarios = aula.getComentarioAulas();

        if (comentarios != null && !comentarios.isEmpty()) {
            double media = comentarios.stream()
                    .mapToInt(ComentarioAula::getAvaliacao)
                    .average()
                    .orElse(0.0);
            aula.setAvaliacaoDaAula(media);
        } else {
            aula.setAvaliacaoDaAula(0.0);
        }
        aulaRepository.save(aula);
    }
}
