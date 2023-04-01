package com.livrariasantanler.santanler.model.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class EditoraDTO {
    private Long id;
    @Size(max=255, message = "Tamanho do nome acima do valor")
    @NotBlank(message = "Nome deve conter algum valor")
    private String nome;
    private String descricao;

}
