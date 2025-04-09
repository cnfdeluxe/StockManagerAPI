package com.api.stockManagerApp.movimiento.application.service;

import com.api.stockManagerApp.movimiento.application.dto.MovimientoStockDTO;
import com.api.stockManagerApp.movimiento.domain.model.MovimientoStock;
import com.api.stockManagerApp.movimiento.domain.port.in.MovimientoStockUseCase;
import com.api.stockManagerApp.movimiento.domain.port.out.MovimientoStockRepositoryPort;
import com.api.stockManagerApp.movimiento.infrastructure.mapper.MovimientoStockMapper;
import com.api.stockManagerApp.producto.domain.model.Producto;
import com.api.stockManagerApp.producto.domain.port.out.ProductoRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MovimientoStockService implements MovimientoStockUseCase {

    private final MovimientoStockRepositoryPort repository;
    private final MovimientoStockMapper mapper;
    private final ProductoRepositoryPort productoRepository;


    @Override
    public List<MovimientoStockDTO> obtenerTodos() {
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public MovimientoStockDTO obtenerPorId(Long id) {
        return repository.findById(id).map(mapper::toDTO).orElseThrow(() -> new RuntimeException("Movimiento no encontrado"));
    }

    @Override
    public MovimientoStockDTO registrar(MovimientoStockDTO dto) {
        // Buscar el producto
        Producto producto = productoRepository.findById(dto.getIdProducto())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // Calcular nuevo stock
        int stockActual = producto.getStockActual();
        int cantidad = dto.getCantidad();

        if (dto.getTipo().equalsIgnoreCase("ENTRADA")) {
            producto.setStockActual(stockActual + cantidad);
        } else if (dto.getTipo().equalsIgnoreCase("SALIDA")) {
            if (stockActual < cantidad) {
                throw new RuntimeException("Stock insuficiente para la salida");
            }
            producto.setStockActual(stockActual - cantidad);
        }

        productoRepository.save(producto);

        int nuevoStock = producto.getStockActual();
        int umbral = producto.getUmbral(); // suponiendo que lo tienes como campo

        if (dto.getTipo().equalsIgnoreCase("SALIDA")) {
            if (nuevoStock == 0) {
                generarAlerta(producto, stockActual, nuevoStock, AlertaStock.TipoAlerta.SIN_STOCK);
            } else if (nuevoStock < umbral) {
                generarAlerta(producto, stockActual, nuevoStock, AlertaStock.TipoAlerta.BAJO_STOCK);
            }
        }



        // Guardar movimiento
        MovimientoStock movimiento = mapper.toEntity(dto);
        return mapper.toDTO(repository.save(movimiento));
    }

    private void generarAlerta(Producto producto, int stockAnterior, int stockActual, AlertaStock.TipoAlerta tipo) {
        AlertaStock alerta = AlertaStock.builder()
                .idProducto(producto.getId())
                .stockAnterior(stockAnterior)
                .stockActual(stockActual)
                .umbral(producto.getUmbral())
                .tipoAlerta(tipo)
                .build();

        alertaStockRepository.save(alerta);

        // más adelante: kafkaTemplate.send("stock-alerts", alerta);
    }

}
