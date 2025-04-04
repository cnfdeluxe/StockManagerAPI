package com.api.stockManagerApp.producto.domain.port.out;

import com.api.stockManagerApp.producto.domain.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoRepositoryPort {

    List<Producto> findAll();
    Optional<Producto> findById(Long id);
    Producto save(Producto producto);
    void deleteById(Long id);

}
