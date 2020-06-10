package com.gavilan.pymesapirest.controllers;

import com.gavilan.pymesapirest.model.entities.ArticuloFamilia;
import com.gavilan.pymesapirest.model.services.ArticuloFamiliaService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @DeleteMapping("/articulos-familia/{id}")
    public ResponseEntity<?> eliminarArticuloFamilia(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            articuloFamiliaService.delete(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar familia de articulo en la base de datos.");
            response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        response.put("mensaje", "ArticuloFamilia eliminado con éxito.");
        
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
