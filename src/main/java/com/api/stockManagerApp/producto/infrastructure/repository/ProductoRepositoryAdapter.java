package com.api.stockManagerApp.producto.infrastructure.repository;

import com.api.stockManagerApp.producto.domain.model.Producto;
import com.api.stockManagerApp.producto.domain.port.out.ProductoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProductoRepositoryAdapter implements ProductoRepositoryPort {

    private final JpaProductoRepository jpaRepository;

    @Override
    public List<Producto> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public Producto save(Producto producto) {
        return jpaRepository.save(producto);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
