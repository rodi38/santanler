package com.livrariasantanler.santanler.service;

import com.livrariasantanler.santanler.model.dto.LivroDTO;
import com.livrariasantanler.santanler.model.entity.LivroEntity;
import com.livrariasantanler.santanler.model.mapper.LivroMapper;
import com.livrariasantanler.santanler.repository.LivroRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LivroService {
    @Autowired
    private LivroRepository repository;
    @Autowired
    private LivroMapper mapper;

    public LivroDTO pegarPorId(Long id) {
        Optional<LivroEntity> livroEntityOptional = repository.findById(id);
        if (livroEntityOptional.isPresent()) {
            LivroEntity livroEntity = livroEntityOptional.get();
            return mapper.update(livroEntity);
        }
        throw new EntityNotFoundException("Livro não encontrado, revisa isso ai meu chapa!");
    }
    public List<LivroDTO> pegarPorNome(String nome) {
        if (!repository.findByNome(nome).isEmpty()){
            List<LivroEntity> livroEntities = repository.findByNome(nome);
            return mapper.updateListDTO(livroEntities);
        }
        throw new EntityNotFoundException("Livro não encontrado, revisa isso ai meu chapa!");
    }

    public LivroDTO pegarPorIsbn(String isbn) {
        if (!repository.findByNome(isbn).isEmpty()){
            LivroEntity livroEntity = repository.findByIsbn(isbn);
            return mapper.update(livroEntity);
        }
        throw new EntityNotFoundException("Livro não encontrado, revisa isso ai meu chapa!");
    }

    public LivroDTO criar(LivroDTO livroDTO) {
        LivroEntity livro = mapper.update(livroDTO);
        livro = repository.save(livro);
        return mapper.update(livro);
    }

    public LivroDTO editar(LivroDTO livroDTO, Long id) {
        if (repository.existsById(id)) {
            LivroEntity livroEntity = mapper.update(livroDTO);
            livroEntity.setId(id);
            livroEntity = repository.save(livroEntity);
            return mapper.update(livroEntity);
        }
        throw new EntityNotFoundException("Livro não encontrado, revisa isso ai meu chapa!");
    }

    public void deletar(Long id) {
        Optional<LivroEntity> livroEntityOptional = repository.findById(id);
        if (livroEntityOptional.isPresent()) {
            LivroEntity LivroEntity = livroEntityOptional.get();
            repository.delete(LivroEntity);
            return;
        }
        throw new EntityNotFoundException("Livro não encontrado, revisa isso ai meu chapa!");
    }

    public List<LivroDTO> listar() {
        List<LivroEntity> listaEntities = repository.findAll();
        return mapper.updateListDTO(listaEntities);
    }
}
