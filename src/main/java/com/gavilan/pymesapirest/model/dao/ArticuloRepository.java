package com.gavilan.pymesapirest.model.dao;

import com.gavilan.pymesapirest.model.entities.Articulo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Ezequiel Gavilán
 */
public interface ArticuloRepository extends CrudRepository<Articulo, Long> {

    public List<Articulo> findAllByOrderByNombreAsc();

}
