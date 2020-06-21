package com.gavilan.pymesapirest.model.services;

import com.gavilan.pymesapirest.model.entities.Empresa;

import java.util.List;

public interface EmpresaService {

    List<Empresa> findAll();

    Empresa findById(Long id);

    Empresa save(Empresa empresa);

    Empresa update(Empresa empresa, Long id);

    void delete(Long id);
}
