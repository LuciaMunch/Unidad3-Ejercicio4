package com.programacion4.unidad3ej4.feature.producto.services.impl.domain;

import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej4.config.exceptions.ResourceNotFoundException;
import com.programacion4.unidad3ej4.feature.producto.models.Producto;
import com.programacion4.unidad3ej4.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej4.feature.producto.services.interfaces.domain.IProductoDeleteService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductoDeleteService implements IProductoDeleteService {

    private final IProductoRepository productoRepository;

    @Override
    public void delete(Long id) {

        // Verificar que el producto exista y no esté ya eliminado
        Producto producto = productoRepository.findByIdAndEstaEliminadoFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Producto no encontrado con id: " + id));

        // Soft delete: cambiar estaEliminado de false a true
        producto.setEstaEliminado(true);
        productoRepository.save(producto);
    }
}
