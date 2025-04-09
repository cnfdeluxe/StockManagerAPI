package com.api.stockManagerApp.proveedor.domain.port.out;

import com.api.stockManagerApp.proveedor.domain.model.Proveedor;

import java.util.List;
import java.util.Optional;

public interface ProveedorRepositoryPort {


    List<Proveedor> findAll();
    Optional<Proveedor> findById(Long id);
    Proveedor save(Proveedor proveedor);
    void deleteById(Long id);



}
