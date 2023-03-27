package com.livrariasantanler.santanler.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LivroDTO {

    private Long id;
    @Size(max=80, message = "Tamanho do nome acima do valor")
    @NotBlank(message = "Nome deve conter algum valor")
    private String nome;
    private String isbn;
}
