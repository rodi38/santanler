package com.livrariasantanler.santanler.service;

import com.livrariasantanler.santanler.model.dto.CategoriaDTO;
import com.livrariasantanler.santanler.model.entity.CategoriaEntity;
import com.livrariasantanler.santanler.model.mapper.CategoriaMapper;
import com.livrariasantanler.santanler.repository.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repository;
    @Autowired
    private CategoriaMapper mapper;

    public CategoriaDTO pegarPorId(Long id) {
        Optional<CategoriaEntity> categoriaEntityOptional = repository.findById(id);
        if (categoriaEntityOptional.isPresent()) {
            CategoriaEntity categoriaEntity = categoriaEntityOptional.get();
            return mapper.update(categoriaEntity);
        }
        throw new EntityNotFoundException("Categoria não encontrada, revisa isso ai meu chapa!");
    }

    public CategoriaDTO criar(CategoriaDTO categoriaDTO) {
        CategoriaEntity categoria = mapper.update(categoriaDTO);
        categoria = repository.save(categoria);
        return mapper.update(categoria);
    }

    public CategoriaDTO editar(CategoriaDTO categoriaDTO, Long id) {
        if (repository.existsById(id)) {
            CategoriaEntity categoriaEntity = mapper.update(categoriaDTO);
            categoriaEntity.setId(id);
            categoriaEntity = repository.save(categoriaEntity);
            return mapper.update(categoriaEntity);
        }
        throw new EntityNotFoundException("Categoria não encontrada, revisa isso ai meu chapa!");
    }

    public void deletar(Long id) {
        Optional<CategoriaEntity> categoriaEntityOptional = repository.findById(id);
        if (categoriaEntityOptional.isPresent()) {
            CategoriaEntity categoriaEntity = categoriaEntityOptional.get();
            repository.delete(categoriaEntity);
            return;
        }
        throw new EntityNotFoundException("Categoria não encontrada, revisa isso ai meu chapa!");
    }

    public List<CategoriaDTO> listar() {
        List<CategoriaEntity> listaEntities = repository.findAll();
        return mapper.updateListDTO(listaEntities);
    }

}
