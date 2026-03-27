package com.programacion4.unidad3ej4.feature.producto.services.impl.domain;

import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej4.config.exceptions.ResourceNotFoundException;
import com.programacion4.unidad3ej4.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej4.feature.producto.mappers.ProductoMapper;
import com.programacion4.unidad3ej4.feature.producto.models.Producto;
import com.programacion4.unidad3ej4.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.domain.IProductoGetByIdService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductoGetByIdService implements IProductoGetByIdService {

    private final IProductoRepository productoRepository;

    @Override
    public ProductoResponseDto getById(Long id) {
        // US03: si no existe o estaEliminado = true → 404
        Producto producto = productoRepository.findByIdAndEstaEliminadoFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Producto no encontrado con id: " + id));

        return ProductoMapper.toResponseDto(producto);
    }
}