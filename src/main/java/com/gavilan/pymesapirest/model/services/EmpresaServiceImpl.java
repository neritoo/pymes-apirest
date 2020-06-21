package com.gavilan.pymesapirest.model.services;

import com.gavilan.pymesapirest.model.dao.EmpresaRepository;
import com.gavilan.pymesapirest.model.entities.Empresa;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaServiceImpl implements EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaServiceImpl(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @Override
    public List<Empresa> findAll() {
        return (List<Empresa>) this.empresaRepository.findAll();
    }

    @Override
    public Empresa findById(Long id) {
        return this.empresaRepository.findById(id).orElse(null);
    }

    @Override
    public Empresa save(Empresa empresa) {
        return this.empresaRepository.save(empresa);
    }

    @Override
    public Empresa update(Empresa empresa, Long id) {
        Empresa empresaActual = this.findById(id);
        Empresa empresaActualizado;

        empresaActual.setRazonSocial(empresa.getRazonSocial());
        empresaActual.setCantidadEmpleados(empresa.getCantidadEmpleados());
        empresaActual.setFechaFundacion(empresa.getFechaFundacion());

        empresaActualizado = this.save(empresaActual);

        return empresaActualizado;
    }

    @Override
    public void delete(Long id) {
        this.empresaRepository.deleteById(id);
    }
}
