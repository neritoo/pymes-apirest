package com.gavilan.pymesapirest.model.services;

import com.gavilan.pymesapirest.model.dao.ArticuloRepository;
import com.gavilan.pymesapirest.model.entities.Articulo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ezequiel Gavilán
 */

@Service
public class ArticuloServiceImpl implements ArticuloService {

    private final ArticuloRepository articuloRepository;

    public ArticuloServiceImpl(ArticuloRepository articuloRepository) {
        this.articuloRepository = articuloRepository;
    }

    @Override
    public List<Articulo> findAll() {
        return (List<Articulo>) this.articuloRepository.findAll();
    }

    @Override
    public List<Articulo> findAllOrdenadosNombre() {
        return this.articuloRepository.findAllByOrderByNombreAsc();
    }

    @Override
    public Articulo findById(Long id) {
        return this.articuloRepository.findById(id).orElse(null);
    }

    @Override
    public Articulo save(Articulo articulo) {
        return this.articuloRepository.save(articulo);
    }

    @Override
    public Articulo update(Articulo articulo, Long id) {
        Articulo articuloActual = this.findById(id);
        Articulo articuloActualizado;

        articuloActual.setNombre(articulo.getNombre());
        articuloActual.setPrecio(articulo.getPrecio());
        articuloActual.setArticulosFamilia(articulo.getArticulosFamilia());
        articuloActual.setCodigoBarra(articulo.getCodigoBarra());
        articuloActual.setFechaAlta(articulo.getFechaAlta());
        articuloActual.setStock(articulo.getStock());

        articuloActualizado = this.save(articuloActual);

        return articuloActualizado;
    }

    @Override
    public Articulo cambiarEstado(Articulo articulo, Long id) {

        Articulo actual = this.findById(id);
        Articulo cambiadoEstado;

        actual.setActivo(!articulo.isActivo());

        cambiadoEstado = this.save(actual);

        return cambiadoEstado;
    }

    @Override
    public void delete(Long id) {
        this.articuloRepository.deleteById(id);
    }
}
