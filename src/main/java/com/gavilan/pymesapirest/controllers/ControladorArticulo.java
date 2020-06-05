package com.gavilan.pymesapirest.controllers;

import com.gavilan.pymesapirest.model.entities.Articulo;
import com.gavilan.pymesapirest.model.services.ArticuloService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Ezequiel Gavilán
 */

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class ControladorArticulo {

    private final ArticuloService articuloService;

    public ControladorArticulo(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    @GetMapping("/articulos")
    public ResponseEntity<?> getArticulos() {

        List<Articulo> articulos;
        Map<String, Object> response = new HashMap<>();

        try {
            articulos = articuloService.findAll();
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (articulos.size() == 0) {
            response.put("mensaje", "No existen articulos en la base de datos.");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        response.put("Lista", articulos);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/articulos/{id}")
    public Articulo getArticulo(@PathVariable Long id) {
        return articuloService.findById(id);
    }

    @PostMapping("/articulos")
    public Articulo crearArticulo(@RequestBody Articulo articulo) {
        return articuloService.save(articulo);
    }

    @PutMapping("/articulos/{id}")
    public Articulo modificarArticulo(@RequestBody Articulo articulo, @PathVariable Long id) {
        return articuloService.update(articulo, id);
    }

    @PutMapping("/articulos/estado/{id}")
    public Articulo cambiarEstadoArticulo(@PathVariable Long id) {
        return articuloService.cambiarEstado(id);
    }

    @DeleteMapping("/articulos/{id}")
    public ResponseEntity<?> eliminarArticulo(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();

        try {
            articuloService.delete(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al eliminar en la base de datos.");
            response.put("error", e.getMessage() + ": " + e.getMostSpecificCause().getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "Articulo eliminado con éxito");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
