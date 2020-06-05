package com.gavilan.pymesapirest.model.services;

import com.gavilan.pymesapirest.model.dao.ArticuloFamiliaRepository;
import com.gavilan.pymesapirest.model.entities.ArticuloFamilia;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ezequiel Gavilán
 */

@Service
public class ArticuloFamiliaServiceImpl implements ArticuloFamiliaService {

    private final ArticuloFamiliaRepository articuloFamiliaRepository;

    public ArticuloFamiliaServiceImpl(ArticuloFamiliaRepository articuloFamiliaRepository) {
        this.articuloFamiliaRepository = articuloFamiliaRepository;
    }

    @Override
    public List<ArticuloFamilia> findAll() {
        return (List<ArticuloFamilia>) this.articuloFamiliaRepository.findAll();
    }

    @Override
    public ArticuloFamilia findById(Long id) {
        return this.articuloFamiliaRepository.findById(id).orElse(null);
    }

    @Override
    public ArticuloFamilia save(ArticuloFamilia articuloFamilia) {
        return this.articuloFamiliaRepository.save(articuloFamilia);
    }

    @Override
    public ArticuloFamilia update(ArticuloFamilia articuloFamilia, Long id) {

        ArticuloFamilia actual = this.findById(id);
        ArticuloFamilia actualizado;

        actual.setNombre(articuloFamilia.getNombre());

        actualizado = this.save(actual);

        return actualizado;
    }

    @Override
    public void delete(Long id) {
        this.articuloFamiliaRepository.deleteById(id);
    }
}
