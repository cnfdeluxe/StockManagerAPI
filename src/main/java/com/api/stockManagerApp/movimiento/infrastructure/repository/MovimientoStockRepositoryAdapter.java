package com.api.stockManagerApp.movimiento.infrastructure.repository;

import com.api.stockManagerApp.movimiento.domain.model.MovimientoStock;
import com.api.stockManagerApp.movimiento.domain.port.out.MovimientoStockRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class MovimientoStockRepositoryAdapter implements MovimientoStockRepositoryPort {

    private final JpaMovimientoStockRepository jpaRepository;

    @Override
    public List<MovimientoStock> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public Optional<MovimientoStock> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public MovimientoStock save(MovimientoStock movimiento) {
        return jpaRepository.save(movimiento);
    }
}
