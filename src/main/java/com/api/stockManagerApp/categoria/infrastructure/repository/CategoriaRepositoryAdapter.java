package com.api.stockManagerApp.categoria.infrastructure.repository;

import com.api.stockManagerApp.categoria.domain.model.Categoria;
import com.api.stockManagerApp.categoria.domain.port.out.CategoriaRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class CategoriaRepositoryAdapter implements CategoriaRepositoryPort {

    private final JpaCategoriaRepository jpaRepository;

    @Override
    public List<Categoria> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public Optional<Categoria> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public Categoria save(Categoria categoria) {
        return jpaRepository.save(categoria);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
