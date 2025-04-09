package com.api.stockManagerApp.proveedor.infrastructure.repository;

import com.api.stockManagerApp.proveedor.domain.model.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProveedorRepository extends JpaRepository<Proveedor, Long> {
}
