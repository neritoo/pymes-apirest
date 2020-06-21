package com.gavilan.pymesapirest.model.dao;

import com.gavilan.pymesapirest.model.entities.Empresa;
import org.springframework.data.repository.CrudRepository;

public interface EmpresaRepository extends CrudRepository<Empresa, Long> {
}
