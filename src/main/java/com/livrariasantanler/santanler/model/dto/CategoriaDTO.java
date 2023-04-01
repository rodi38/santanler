package com.livrariasantanler.santanler.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class CategoriaDTO {
    private Long id;
    @Size(max=100, message = "Tamanho do nome acima do valor")
    @NotBlank(message = "Nome deve conter algum valor")
    private String nome;


}
