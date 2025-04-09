package com.api.stockManagerApp.proveedor.infrastructure.repository;

import com.api.stockManagerApp.proveedor.domain.model.Proveedor;
import com.api.stockManagerApp.proveedor.domain.port.out.ProveedorRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProveedorRepositoryAdapter implements ProveedorRepositoryPort {

    private final JpaProveedorRepository jpaRepository;


    @Override
    public List<Proveedor> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public Optional<Proveedor> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public Proveedor save(Proveedor proveedor) {
        return jpaRepository.save(proveedor);
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}
