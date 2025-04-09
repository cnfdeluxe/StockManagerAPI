package com.api.stockManagerApp.movimiento.infrastructure.controller;

import com.api.stockManagerApp.movimiento.application.dto.MovimientoStockDTO;
import com.api.stockManagerApp.movimiento.domain.port.in.MovimientoStockUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movimientos")
@RequiredArgsConstructor
public class MovimientoStockController {

    private final MovimientoStockUseCase useCase;

    @GetMapping
    public ResponseEntity<List<MovimientoStockDTO>> obtenerTodos() {
        return ResponseEntity.ok(useCase.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovimientoStockDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(useCase.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<MovimientoStockDTO> registrar(@RequestBody MovimientoStockDTO dto) {
        return ResponseEntity.ok(useCase.registrar(dto));
    }

}
