package com.api.stockManagerApp.producto.infrastructure.repository;

import com.api.stockManagerApp.producto.domain.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductoRepository extends JpaRepository<Producto, Long> {
}
