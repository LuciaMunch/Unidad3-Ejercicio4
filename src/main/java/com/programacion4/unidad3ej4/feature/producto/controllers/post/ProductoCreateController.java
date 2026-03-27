package com.programacion4.unidad3ej4.feature.producto.controllers.post;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.programacion4.unidad3ej4.config.BaseResponse;
import com.programacion4.unidad3ej4.feature.producto.dtos.request.ProductoCreateRequestDto;
import com.programacion4.unidad3ej4.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.domain.IProductoCreateService;

import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/productos")
@AllArgsConstructor
public class ProductoCreateController {

    private final IProductoCreateService productoCreateService;

    @PostMapping
    public ResponseEntity<BaseResponse<ProductoResponseDto>> create(
        @Valid @RequestBody ProductoCreateRequestDto dto) {
        return ResponseEntity.ok(
            BaseResponse.ok(
                productoCreateService.create(dto), 
                "Producto creado correctamente"
            )
        );
    }
}
