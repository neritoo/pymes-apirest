package com.gavilan.pymesapirest.model.services;

import com.gavilan.pymesapirest.model.entities.Articulo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author Ezequiel Gavilán
 */
public interface ArticuloService {

    // List<Articulo> findAll();

    Page<Articulo> findAll(Pageable pageable);

    List<Articulo> findAllOrdenadosNombre();

    Articulo findById(Long id);

    Articulo save(Articulo articulo);

    Articulo update(Articulo articulo, Long id);

    void delete(Long id);

    Articulo cambiarEstado(Articulo articulo, Long id);

}
