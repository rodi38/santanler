package com.livrariasantanler.santanler.model.dto;

import com.livrariasantanler.santanler.model.entity.CategoriaEntity;
import com.livrariasantanler.santanler.model.entity.EditoraEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class LivroDTO {

    private Long id;
    @Size(max=100, message = "Tamanho do nome acima do valor")
    @NotBlank(message = "Nome deve conter algum valor")
    private String nome;
    @Size(max=13, min = 5, message = "ISBN só pode conter até 13 caracteres")
    @NotBlank(message = "Nome deve conter algum valor")
    private String isbn;
    private CategoriaDTO categoria;
    private EditoraDTO editora;

}
