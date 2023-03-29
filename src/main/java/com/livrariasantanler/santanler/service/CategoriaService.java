package com.livrariasantanler.santanler.service;

import com.livrariasantanler.santanler.model.mapper.CategoriaMapper;
import com.livrariasantanler.santanler.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
    private CategoriaRepository repository;
    private CategoriaMapper categoriaMapper;
}
