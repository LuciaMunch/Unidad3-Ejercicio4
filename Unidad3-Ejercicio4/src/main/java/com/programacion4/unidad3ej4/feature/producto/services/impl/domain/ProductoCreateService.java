package com.programacion4.unidad3ej4.feature.producto.services.impl.domain;

import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej4.config.exceptions.ResourceConflictException;
import com.programacion4.unidad3ej4.config.exceptions.ResourceNotFoundException;
import com.programacion4.unidad3ej4.feature.producto.dtos.request.ProductoCreateRequestDto;
import com.programacion4.unidad3ej4.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej4.feature.producto.mappers.ProductoMapper;
import com.programacion4.unidad3ej4.feature.producto.models.Categoria;
import com.programacion4.unidad3ej4.feature.producto.models.Producto;
import com.programacion4.unidad3ej4.feature.producto.repositories.ICategoriaRepository;
import com.programacion4.unidad3ej4.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.commons.IProductoExistByNameService;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.domain.IProductoCreateService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductoCreateService implements IProductoCreateService {

    private final IProductoExistByNameService productoExistByNameService;
    private final IProductoRepository productoRepository;
    private final ICategoriaRepository categoriaRepository;

    @Override
    public ProductoResponseDto create(ProductoCreateRequestDto dto) {

        // US01: nombre duplicado → 409 Conflict
        if (productoExistByNameService.existByName(dto.getNombre())) {
            throw new ResourceConflictException("Ya existe un producto con el nombre: " + dto.getNombre());
        }

        // US01: validar que la categoría exista
        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Categoría no encontrada con id: " + dto.getCategoriaId()));

        // US01: capitalize nombre y descripción
        String nombreCapitalizado = capitalize(dto.getNombre());
        String descripcionCapitalizada = capitalize(dto.getDescripcion());

        dto.setNombre(nombreCapitalizado);
        dto.setDescripcion(descripcionCapitalizada);

        // US01: estaEliminado = false (lo maneja el mapper/builder)
        Producto productoAGuardar = ProductoMapper.toEntity(dto, categoria);
        productoAGuardar.setEstaEliminado(false);

        Producto productoGuardado = productoRepository.save(productoAGuardar);

        return ProductoMapper.toResponseDto(productoGuardado);
    }

    /**
     * Convierte la primera letra a mayúscula y el resto a minúsculas.
     * Ejemplo: "remera DE ALGODÓN" → "Remera de algodón"
     */
    private String capitalize(String texto) {
        if (texto == null || texto.isBlank()) return texto;
        String lower = texto.toLowerCase();
        return Character.toUpperCase(lower.charAt(0)) + lower.substring(1);
    }
}
