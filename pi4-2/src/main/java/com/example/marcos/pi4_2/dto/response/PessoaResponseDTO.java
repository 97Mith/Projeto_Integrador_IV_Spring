package com.example.marcos.pi4_2.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PessoaResponseDTO {
    private Integer id;
    private String nome;
    private String cpf;
    private String tel;
    private String email;
    private String senha;
    private String cargo;
    private boolean estaAtivo;
}
