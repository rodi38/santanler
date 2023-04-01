package com.livrariasantanler.santanler.model.mapper;

import com.livrariasantanler.santanler.model.dto.EditoraDTO;
import com.livrariasantanler.santanler.model.entity.EditoraEntity;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class EditoraMapper {
    public EditoraDTO update(EditoraEntity editora) {
        EditoraDTO editoraDTO = new EditoraDTO();
        editoraDTO.setId(editora.getId());
        editoraDTO.setNome(editora.getNome());
        editoraDTO.setDescricao(editora.getDescricao());
        return editoraDTO;
    }

    public EditoraEntity update(EditoraDTO editora) {
        EditoraEntity editoraEntity = new EditoraEntity();
        editoraEntity.setId(editora.getId());
        editoraEntity.setNome(editora.getNome());
        editoraEntity.setDescricao(editora.getDescricao());
        return editoraEntity;
    }

    public List<EditoraDTO> updateListDTO(List<EditoraEntity> listaEntity) {
        return listaEntity.stream().map(editora -> update(editora)).toList();
    }

    public List<EditoraEntity> updateListEntity(List<EditoraDTO> listaDTO) {
        return listaDTO.stream().map(editora -> update(editora)).toList();
    }

}
