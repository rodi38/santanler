package com.livrariasantanler.santanler.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@Table(name = "livro")
@ToString
public class LivroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", nullable = false, unique = true)
    private String nome;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "editora", nullable = false)
    private EditoraEntity EditoraEntity;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria", nullable = false)
    private CategoriaEntity categoriaEntity;
    @Column(name = "isbn")
    private String isbn;


}
