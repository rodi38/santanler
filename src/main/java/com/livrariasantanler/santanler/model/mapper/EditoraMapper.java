package com.livrariasantanler.santanler.model.mapper;

import com.livrariasantanler.santanler.model.dto.EditoraDTO;
import com.livrariasantanler.santanler.model.entity.EditoraEntity;

public class EditoraMapper {
    private CategoriaMapper categoriaMapper = new CategoriaMapper();

    public EditoraDTO update(EditoraEntity editora) {
        EditoraDTO editoraDTO = new EditoraDTO();
        editoraDTO.setId(editora.getId());
        editoraDTO.setNome(editora.getNome());
        editoraDTO.setCategorias(categoriaMapper.updateListDTO(editora.getCategorias()));
        return editoraDTO;
        //incompleto prob
    }
}
