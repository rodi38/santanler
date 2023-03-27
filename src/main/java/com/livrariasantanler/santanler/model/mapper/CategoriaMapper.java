package com.livrariasantanler.santanler.model.mapper;

import com.livrariasantanler.santanler.model.dto.CategoriaDTO;
import com.livrariasantanler.santanler.model.entity.CategoriaEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CategoriaMapper {
    public CategoriaDTO update(CategoriaEntity categoria) {
        CategoriaDTO categoriaDTO = new CategoriaDTO();
        categoriaDTO.setId(categoria.getId());
        categoriaDTO.setNome(categoria.getNome());
        return categoriaDTO;
    }
    public CategoriaEntity update(CategoriaDTO categoria) {
        CategoriaEntity categoriaEntity = new CategoriaEntity();
        categoriaEntity.setId(categoria.getId());
        categoriaEntity.setNome(categoria.getNome());
        return categoriaEntity;

    }
    public List<CategoriaDTO> updateListDTO(List<CategoriaEntity> listaDTO) {
        return listaDTO.stream().map(categoria -> update(categoria)).toList();
    }

    public List<CategoriaEntity> updateListEntity(List<CategoriaDTO> listaEntity) {
        return listaEntity.stream().map(categoria -> update(categoria)).toList();
    }

}
