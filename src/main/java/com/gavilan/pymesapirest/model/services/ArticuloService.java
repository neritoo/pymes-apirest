package com.gavilan.pymesapirest.model.services;

import com.gavilan.pymesapirest.model.entities.Articulo;

import java.util.List;

/**
 * @author Ezequiel Gavilán
 */
public interface ArticuloService {

    List<Articulo> findAll();

    Articulo findById(Long id);

    Articulo save(Articulo articulo);

    Articulo update(Articulo articulo, Long id);

    Articulo cambiarEstado(Long id);

    void delete(Long id);
}
