package com.gavilan.pymesapirest.model.dao;

import com.gavilan.pymesapirest.model.entities.Articulo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Ezequiel Gavilán
 */
public interface ArticuloRepository extends JpaRepository<Articulo, Long> {

    List<Articulo> findAllByOrderByNombreAsc();

    Page<Articulo> findAllByNombreContaining(String termino, Pageable pageable);

    Page<Articulo> findAllByNombreContainingAndActivo(String termino, Boolean activo, Pageable pageable);

}
