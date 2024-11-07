package com.example.marcos.pi4_2.services;

import com.example.marcos.pi4_2.entities.Professor;
import com.example.marcos.pi4_2.repositories.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class ProfessorServiceImplement implements ProfessorService {

    private final ProfessorRepository professorRepository;

    @Override
    public Professor findById(Integer id) {
        return returnProfessor(id);
    }

    @Override
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    @Override
    public Professor register(Professor professor) {
        return professorRepository.save(professor);
    }

    @Override
    public Professor update(Professor professor, Integer id) {
        Professor professorToUpdate = returnProfessor(id);
        updateProfessorData(professorToUpdate, professor);
        return professorRepository.save(professorToUpdate);
    }

    @Override
    public String delete(Integer id) {
        professorRepository.deleteById(id);
        return "Professor excluído com sucesso!";
    }

    private Professor returnProfessor(Integer id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado no banco de dados"));
    }

    private void updateProfessorData(Professor professorToUpdate, Professor professor) {
        professorToUpdate.setNome(professor.getNome());
        professorToUpdate.setCpf(professor.getCpf());
        professorToUpdate.setTel(professor.getTel());
        professorToUpdate.setEmail(professor.getEmail());
        professorToUpdate.setSenha(professor.getSenha());
        professorToUpdate.setCargo(professor.getCargo());
        professorToUpdate.setEstaAtivo(professor.isEstaAtivo());
        professorToUpdate.setTurmas(professor.getTurmas());
        professorToUpdate.setLicenca(professor.getLicenca());
        professorToUpdate.setAulas(professor.getAulas());
    }
}
