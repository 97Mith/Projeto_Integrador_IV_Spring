package com.example.marcos.pi4_2.util;

import com.example.marcos.pi4_2.dto.request.GestorRequestDTO;
import com.example.marcos.pi4_2.dto.response.GestorResponseDTO;
import com.example.marcos.pi4_2.entities.Gestor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GestorMapper {

    public Gestor toGestor(GestorRequestDTO gestorDTO) {
        return Gestor.builder()
                .nome(gestorDTO.getNome())
                .cpf(gestorDTO.getCpf())
                .tel(gestorDTO.getTel())
                .email(gestorDTO.getEmail())
                .senha(gestorDTO.getSenha())
                .cargo(gestorDTO.getCargo())
                .estaAtivo(gestorDTO.isEstaAtivo())
                .build();
    }

    public GestorResponseDTO toGestorDTO(Gestor gestor){
        return new GestorResponseDTO(gestor);
    }

    public List<GestorResponseDTO> toGestoresDTO(List<Gestor> gestoresList){
        return gestoresList.stream().map(GestorResponseDTO::new).collect(Collectors.toList());
    }

    public void updateGestorData(Gestor gestor, GestorRequestDTO gestorDTO) {
        gestor.setNome(gestorDTO.getNome());
        gestor.setCpf(gestorDTO.getCpf());
        gestor.setTel(gestorDTO.getTel());
        gestor.setEmail(gestorDTO.getEmail());
        gestor.setSenha(gestorDTO.getSenha());
        gestor.setCargo(gestorDTO.getCargo());
        gestor.setEstaAtivo(gestorDTO.isEstaAtivo());
    }

}
