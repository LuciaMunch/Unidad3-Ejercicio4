package com.programacion4.unidad3ej4.feature.producto.mappers;

import com.programacion4.unidad3ej4.feature.producto.dtos.request.ProductoCreateRequestDto;
import com.programacion4.unidad3ej4.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej4.feature.producto.models.Categoria;
import com.programacion4.unidad3ej4.feature.producto.models.Producto;

public class ProductoMapper {
    
    public static Producto toEntity(ProductoCreateRequestDto dto, Categoria categoria) {
        return Producto.builder()
                .nombre(dto.getNombre())
                .codigo(dto.getCodigo())
                .descripcion(dto.getDescripcion())
                .precio(dto.getPrecio())
                .stock(dto.getStock())
                .categoria(categoria)
                .build();
    }

    public static ProductoResponseDto toResponseDto(Producto producto) {
        return ProductoResponseDto.builder()
                .id(producto.getId())
                .nombre(producto.getNombre())
                .codigo(producto.getCodigo())
                .descripcion(producto.getDescripcion())
                .precio(producto.getPrecio())
                .stock(producto.getStock())
                .categoria(CategoriaMapper.toDto(producto.getCategoria()))
                .build();
    }
}
