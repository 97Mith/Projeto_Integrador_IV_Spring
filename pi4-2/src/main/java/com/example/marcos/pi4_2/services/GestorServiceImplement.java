package com.example.marcos.pi4_2.services;

import com.example.marcos.pi4_2.dto.request.GestorRequestDTO;
import com.example.marcos.pi4_2.dto.response.GestorResponseDTO;
import com.example.marcos.pi4_2.entities.Gestor;
import com.example.marcos.pi4_2.repositories.GestorRepository;
import com.example.marcos.pi4_2.util.GestorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class GestorServiceImplement implements GestorService{
    private final GestorRepository gestorRepository;
    private final GestorMapper gestorMapper;
    @Override
    public GestorResponseDTO findById(Integer id) {
        return gestorMapper.toGestorDTO(returnGestor(id));
    }

    @Override
    public List<GestorResponseDTO> findAll() {
        return gestorMapper.toGestoresDTO(gestorRepository.findAll());
    }

    @Override
    public GestorResponseDTO register(GestorRequestDTO gestorDTO) {

        Gestor gestor = gestorMapper.toGestor(gestorDTO);

        return gestorMapper.toGestorDTO(gestorRepository.save(gestor));
    }

    @Override
    public GestorResponseDTO update(GestorRequestDTO gestorDTO, Integer id) {

        Gestor gestor = returnGestor(id);

        gestorMapper.updateGestorData(gestor, gestorDTO);

        return gestorMapper.toGestorDTO(gestorRepository.save(gestor));
    }

    @Override
    public String delete(Integer id) {

        gestorRepository.deleteById(id);

        return "Gestor exluído com sucesso!";
    }

    private Gestor returnGestor(Integer id){
        return gestorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Não encontrado no banco de dados"));
    }
}
