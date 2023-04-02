package com.livrariasantanler.santanler.repository;

import com.livrariasantanler.santanler.model.entity.CategoriaEntity;
import com.livrariasantanler.santanler.model.entity.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, Long> {
    @Query("SELECT l FROM LivroEntity l" +
            " WHERE upper(l.nome) LIKE CONCAT('%', UPPER(:nome),'%')")
    List<LivroEntity> findByNome(@Param("nome") String nome);
    @Query("SELECT l FROM LivroEntity l" +
            " WHERE upper(l.isbn) LIKE CONCAT('%', UPPER(:isbn), '%')")
    LivroEntity findByIsbn(@Param("isbn") String isbn);
    LivroEntity findByCategoria(CategoriaEntity categoria);
}
