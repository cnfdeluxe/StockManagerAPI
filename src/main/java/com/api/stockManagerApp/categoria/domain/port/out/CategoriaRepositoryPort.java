package com.api.stockManagerApp.categoria.domain.port.out;

import com.api.stockManagerApp.categoria.domain.model.Categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepositoryPort {

    List<Categoria> findAll();
    Optional<Categoria> findById(Long id);
    Categoria save(Categoria categoria);
    void deleteById(Long id);

}
