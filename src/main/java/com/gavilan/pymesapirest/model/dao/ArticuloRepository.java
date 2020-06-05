package com.gavilan.pymesapirest.model.dao;

import com.gavilan.pymesapirest.model.entities.Articulo;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Ezequiel Gavilán
 */
public interface ArticuloRepository extends CrudRepository<Articulo, Long> {

}
