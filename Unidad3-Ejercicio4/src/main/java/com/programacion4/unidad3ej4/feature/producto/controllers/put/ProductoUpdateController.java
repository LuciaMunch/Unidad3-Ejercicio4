package com.programacion4.unidad3ej4.feature.producto.controllers.put;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.programacion4.unidad3ej4.config.BaseResponse;
import com.programacion4.unidad3ej4.feature.producto.dtos.request.ProductoUpdateRequestDto;
import com.programacion4.unidad3ej4.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.domain.IProductoUpdateService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/productos")
@AllArgsConstructor
public class ProductoUpdateController {

    private final IProductoUpdateService productoUpdateService;

    @PutMapping("/{id}")
    public ResponseEntity<BaseResponse<ProductoResponseDto>> update(
            @PathVariable Long id,
            @Valid @RequestBody ProductoUpdateRequestDto dto) {

        ProductoResponseDto productoActualizado = productoUpdateService.update(id, dto);

        // US04: 200 OK
        return ResponseEntity.ok(
                BaseResponse.ok(productoActualizado, "Producto actualizado correctamente"));
    }
}
