package com.programacion4.unidad3ej4.feature.producto.mappers;

import com.programacion4.unidad3ej4.feature.producto.dtos.response.CategoriaResponseDto;
import com.programacion4.unidad3ej4.feature.producto.models.Categoria;

public class CategoriaMapper {

    public static CategoriaResponseDto toDto (Categoria categoria) {
        return CategoriaResponseDto.builder()
                .id(categoria.getId())
                .nombre(categoria.getNombre())
                .build();
    }    
}
