package com.api.stockManagerApp.categoria.application.service;

import com.api.stockManagerApp.categoria.application.dto.CategoriaDTO;
import com.api.stockManagerApp.categoria.domain.model.Categoria;
import com.api.stockManagerApp.categoria.domain.port.in.CategoriaUseCase;
import com.api.stockManagerApp.categoria.domain.port.out.CategoriaRepositoryPort;
import com.api.stockManagerApp.categoria.infrastructure.mapper.CategoriaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoriaService implements CategoriaUseCase {

    private final CategoriaRepositoryPort repository;
    private final CategoriaMapper mapper;

    @Override
    public List<CategoriaDTO> obtenerTodas() {
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public CategoriaDTO obtenerPorId(Long id) {
        return repository.findById(id).map(mapper::toDTO).orElseThrow(() -> new RuntimeException("Categoria no encontrada"));
    }

    @Override
    public CategoriaDTO crear(CategoriaDTO dto) {
        Categoria categoria = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(categoria));
    }

    @Override
    public CategoriaDTO actualizar(Long id, CategoriaDTO dto) {
        Categoria categoria = mapper.toEntity(dto);
        categoria.setId(id);
        return mapper.toDTO(repository.save(categoria));
    }

    @Override
    public void eliminar(Long id) {
        repository.deleteById(id);
    }
}
