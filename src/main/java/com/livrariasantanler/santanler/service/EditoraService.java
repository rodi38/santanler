package com.livrariasantanler.santanler.service;

import com.livrariasantanler.santanler.model.dto.EditoraDTO;
import com.livrariasantanler.santanler.model.entity.EditoraEntity;
import com.livrariasantanler.santanler.model.mapper.EditoraMapper;
import com.livrariasantanler.santanler.repository.EditoraRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditoraService {
    @Autowired
    private EditoraRepository repository;
    @Autowired
    private EditoraMapper mapper;

    public EditoraDTO pegarPorId(Long id) {
        Optional<EditoraEntity> editoraEntityOptional = repository.findById(id);
        if (editoraEntityOptional.isPresent()) {
            EditoraEntity editoraEntity = editoraEntityOptional.get();
            return mapper.update(editoraEntity);
        }
        throw new EntityNotFoundException("Editora não encontrada, revisa isso ai meu chapa!");
    }

    public EditoraDTO criar(EditoraDTO editoraDTO) {
        EditoraEntity editora = mapper.update(editoraDTO);
        editora = repository.save(editora);
        return mapper.update(editora);
    }

    public EditoraDTO editar(EditoraDTO editoraDTO, Long id) {
        if (repository.existsById(id)) {
            EditoraEntity editoraEntity = mapper.update(editoraDTO);
            editoraEntity.setId(id);
            editoraEntity = repository.save(editoraEntity);
            return mapper.update(editoraEntity);
        }
        throw new EntityNotFoundException("Editora não encontrada, revisa isso ai meu chapa!");
    }

    public void deletar(Long id) {
        Optional<EditoraEntity> editoraEntityOptional = repository.findById(id);
        if (editoraEntityOptional.isPresent()) {
            EditoraEntity editoraEntity = editoraEntityOptional.get();
            repository.delete(editoraEntity);
            return;
        }
        throw new EntityNotFoundException("Editora não encontrada, revisa isso ai meu chapa!");
    }

    public List<EditoraDTO> listar() {
        List<EditoraEntity> listaEntities = repository.findAll();
        return mapper.updateListDTO(listaEntities);
    }

}
