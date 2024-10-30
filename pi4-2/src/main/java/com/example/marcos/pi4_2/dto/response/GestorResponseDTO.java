package com.example.marcos.pi4_2.dto.response;

import com.example.marcos.pi4_2.entities.Gestor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class GestorResponseDTO extends PessoaResponseDTO {

    public GestorResponseDTO(Gestor gestor) {
        super(
                gestor.getId(),
                gestor.getNome(),
                gestor.getCpf(),
                gestor.getTel(),
                gestor.getEmail(),
                gestor.getSenha(),
                gestor.getCargo(),
                gestor.isEstaAtivo()
        );
    }
}
