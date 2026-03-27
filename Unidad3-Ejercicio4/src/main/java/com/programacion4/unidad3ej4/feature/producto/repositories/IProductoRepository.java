package com.programacion4.unidad3ej4.feature.producto.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.programacion4.unidad3ej4.feature.producto.models.Producto;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductoRepository extends CrudRepository<Producto, Long> {

    boolean existsByNombre(String nombre);

    // Retorna solo productos NO eliminados
    List<Producto> findAllByEstaEliminadoFalse();

    // Busca por id solo si no está eliminado
    Optional<Producto> findByIdAndEstaEliminadoFalse(Long id);
}
