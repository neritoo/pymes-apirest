package com.gavilan.pymesapirest.controllers;

import com.gavilan.pymesapirest.model.entities.ArticuloFamilia;
import com.gavilan.pymesapirest.model.services.ArticuloFamiliaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ezequiel Gavilán
 */

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class ControladorArticuloFamilia {

    private final ArticuloFamiliaService articuloFamiliaService;

    public ControladorArticuloFamilia(ArticuloFamiliaService articuloFamiliaService) {
        this.articuloFamiliaService = articuloFamiliaService;
    }

    @GetMapping("/articulos-familia")
    public List<ArticuloFamilia> getArticulosFamilia() {
        return articuloFamiliaService.findAll();
    }

    @GetMapping("/articulos-familia/{id}")
    public ArticuloFamilia getArticuloFamilia(@PathVariable Long id) {
        return articuloFamiliaService.findById(id);
    }

    @PostMapping("/articulos-familia")
    public ArticuloFamilia crearArticuloFamilia(@RequestBody ArticuloFamilia articuloFamilia) {
        return articuloFamiliaService.save(articuloFamilia);
    }

    @PutMapping("/articulos-familia/{id}")
    public ArticuloFamilia modificarArticuloFamilia(@RequestBody ArticuloFamilia articuloFamilia, @PathVariable Long id) {
        return articuloFamiliaService.update(articuloFamilia, id);
    }

}
