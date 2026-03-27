package com.programacion4.unidad3ej4.feature.producto.services.impl.domain;

import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej4.config.exceptions.ResourceNotFoundException;
import com.programacion4.unidad3ej4.feature.producto.dtos.request.ProductoUpdateRequestDto;
import com.programacion4.unidad3ej4.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej4.feature.producto.mappers.ProductoMapper;
import com.programacion4.unidad3ej4.feature.producto.models.Categoria;
import com.programacion4.unidad3ej4.feature.producto.models.Producto;
import com.programacion4.unidad3ej4.feature.producto.repositories.ICategoriaRepository;
import com.programacion4.unidad3ej4.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.domain.IProductoUpdateService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductoUpdateService implements IProductoUpdateService {

    private final IProductoRepository productoRepository;
    private final ICategoriaRepository categoriaRepository;

    @Override
    public ProductoResponseDto update(Long id, ProductoUpdateRequestDto dto) {

        // Verificar que el producto exista y no esté eliminado
        Producto producto = productoRepository.findByIdAndEstaEliminadoFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Producto no encontrado con id: " + id));

        // Validar que la nueva categoría exista
        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Categoría no encontrada con id: " + dto.getCategoriaId()));

        // Actualizar todos los campos
        producto.setNombre(dto.getNombre());
        producto.setCodigo(dto.getCodigo());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        producto.setCategoria(categoria);

        Producto productoActualizado = productoRepository.save(producto);

        return ProductoMapper.toResponseDto(productoActualizado);
    }
}