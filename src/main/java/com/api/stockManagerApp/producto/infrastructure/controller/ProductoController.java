package com.api.stockManagerApp.producto.infrastructure.controller;

import com.api.stockManagerApp.producto.application.dto.ProductoDTO;
import com.api.stockManagerApp.producto.domain.port.in.ProductoUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoUseCase useCase;

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> obtenerTodos(){
        return ResponseEntity.ok(useCase.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(useCase.obtenerPorId(id));
    }

    @PostMapping
    public ResponseEntity<ProductoDTO> crear(@RequestBody ProductoDTO producto) {
        return ResponseEntity.ok(useCase.crear(producto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> actualizar(@PathVariable Long id, @RequestBody ProductoDTO producto) {
        return ResponseEntity.ok(useCase.actualizar(id, producto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        useCase.eliminar(id);
        return ResponseEntity.noContent().build();
    }




}
