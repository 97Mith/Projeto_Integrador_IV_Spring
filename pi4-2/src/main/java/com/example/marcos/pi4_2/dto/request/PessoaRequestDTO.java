package com.example.marcos.pi4_2.dto.request;

import lombok.Getter;

@Getter
public class PessoaRequestDTO {
    private Integer id;
    private String nome;
    private String cpf;
    private String tel;
    private String email;
    private String senha;
    private String cargo;
    private boolean estaAtivo;
}
