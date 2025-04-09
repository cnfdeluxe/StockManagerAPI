package com.api.stockManagerApp.categoria.infrastructure.repository;


import com.api.stockManagerApp.categoria.domain.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCategoriaRepository extends JpaRepository<Categoria, Long> {



}
