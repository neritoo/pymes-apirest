package com.gavilan.pymesapirest.model.dao;

import com.gavilan.pymesapirest.model.entities.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Ezequiel Gavilán
 */
public interface ArticuloRepository extends JpaRepository<Articulo, Long> {

    public List<Articulo> findAllByOrderByNombreAsc();

}
