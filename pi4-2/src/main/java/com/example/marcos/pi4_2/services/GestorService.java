package com.example.marcos.pi4_2.services;

import com.example.marcos.pi4_2.dto.request.GestorRequestDTO;
import com.example.marcos.pi4_2.dto.response.GestorResponseDTO;

import java.util.List;

public interface GestorService {
    GestorResponseDTO findById(Integer id);
    List<GestorResponseDTO> findAll();
    GestorResponseDTO register(GestorRequestDTO gestorDTO);
    GestorResponseDTO update(GestorRequestDTO gestorDTO, Integer id);
    String delete(Integer id);

}
