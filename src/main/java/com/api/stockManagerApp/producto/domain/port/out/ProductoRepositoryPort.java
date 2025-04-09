package com.api.stockManagerApp.producto.domain.port.out;

import com.api.stockManagerApp.producto.domain.model.Producto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ProductoRepositoryPort {

    List<Producto> findAll();
    Optional<Producto> findById(Long id);
    Producto save(Producto producto);
    void deleteById(Long id);

}
