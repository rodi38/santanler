package com.livrariasantanler.santanler.model.mapper;

import com.livrariasantanler.santanler.model.dto.LivroDTO;
import com.livrariasantanler.santanler.model.entity.LivroEntity;
import org.springframework.stereotype.Component;

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
}
