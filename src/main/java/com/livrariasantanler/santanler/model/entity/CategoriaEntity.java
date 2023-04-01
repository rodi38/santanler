package com.livrariasantanler.santanler.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "categoria")
public class CategoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", nullable = false, unique = true)
    private String nome;
    @OneToMany(mappedBy = "categoria")
    private List<LivroEntity> livros;


}
