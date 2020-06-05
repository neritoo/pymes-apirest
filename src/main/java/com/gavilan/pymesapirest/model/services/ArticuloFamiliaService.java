package com.gavilan.pymesapirest.model.services;

import com.gavilan.pymesapirest.model.entities.ArticuloFamilia;

import java.util.List;

/**
 * @author Ezequiel Gavilán
 */
public interface ArticuloFamiliaService {

    List<ArticuloFamilia> findAll();

    ArticuloFamilia findById(Long id);

    ArticuloFamilia save(ArticuloFamilia articulo);

    ArticuloFamilia update(ArticuloFamilia articuloFamilia, Long id);

    void delete(Long id);
}
