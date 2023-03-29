package com.livrariasantanler.santanler.model.mapper;

import com.livrariasantanler.santanler.model.dto.LivroDTO;
import com.livrariasantanler.santanler.model.entity.EditoraEntity;
import com.livrariasantanler.santanler.model.entity.LivroEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LivroMapper {
    private CategoriaMapper categoriaMapper = new CategoriaMapper();
    private EditoraMapper editoraMapper = new EditoraMapper();
    public LivroDTO update(LivroEntity livro) {
        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setId(livro.getId());
        livroDTO.setNome(livro.getNome());
        livroDTO.setIsbn(livro.getIsbn());
        livroDTO.setCategoria(categoriaMapper.update(livro.getCategoriaEntity()));
        livroDTO.setEditora(editoraMapper.update(livro.getEditoraEntity()));
        return livroDTO;
    }

    public LivroEntity update(LivroDTO livro) {
        LivroEntity livroEntity = new LivroEntity();
        livroEntity.setId(livro.getId());
        livroEntity.setNome(livro.getNome());
        livroEntity.setIsbn(livro.getIsbn());
        livroEntity.setCategoriaEntity(categoriaMapper.update(livro.getCategoria()));
        livroEntity.setEditoraEntity(editoraMapper.update(livro.getEditora()));
        return livroEntity;
    }

    public List<LivroDTO> updateListDTO(List<LivroEntity> listaEntity) {
        return listaEntity.stream().map(livro -> update(livro)).toList();
    }

    public List<LivroEntity> updateListEntity(List<LivroDTO> listaDTO) {
        return listaDTO.stream().map(livro -> update(livro)).toList();
    }
}
