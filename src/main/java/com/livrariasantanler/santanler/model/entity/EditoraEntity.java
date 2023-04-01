package com.livrariasantanler.santanler.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "editora")
public class EditoraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", nullable = false, unique = true)
    private String nome;
    @Column(name = "descricao")
    private String descricao;

    @OneToMany(mappedBy = "editora")
    private List<LivroEntity> livros;
}
