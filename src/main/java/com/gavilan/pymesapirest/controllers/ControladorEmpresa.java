package com.gavilan.pymesapirest.controllers;

import com.gavilan.pymesapirest.model.entities.Empresa;
import com.gavilan.pymesapirest.model.services.EmpresaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class ControladorEmpresa {

    private final EmpresaService empresaService;

    public ControladorEmpresa(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping("/empresas")
    public List<Empresa> obtenerEmpresas() {
        return this.empresaService.findAll();
    }

    @GetMapping("/empresas/{id}")
    public Empresa obtenerEmpresa(@PathVariable Long id) {
        return this.empresaService.findById(id);
    }

    @PostMapping("/empresas")
    public Empresa crearEmpresa(@RequestBody Empresa empresa) {
        return this.empresaService.save(empresa);
    }

    @PutMapping("empresas/{id}")
    public Empresa modificarEmpresa(@RequestBody Empresa empresa, @PathVariable Long id) {
        return this.empresaService.update(empresa, id);
    }

    @DeleteMapping("empresas/{id}")
    public String eliminarEmpresa(@PathVariable Long id) {
        this.empresaService.delete(id);

        return "Empresa eliminada con éxito!";
    }
}
