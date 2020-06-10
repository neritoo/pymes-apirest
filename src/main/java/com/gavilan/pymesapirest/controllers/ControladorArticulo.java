package com.gavilan.pymesapirest.controllers;

import com.gavilan.pymesapirest.model.entities.Articulo;
import com.gavilan.pymesapirest.model.services.ArticuloService;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
public class ControladorArticulo {

    private final ArticuloService articuloService;

    public ControladorArticulo(ArticuloService articuloService) {
        this.articuloService = articuloService;
    }

    @GetMapping("/articulos/page/{page}")
    public ResponseEntity<?> getArticulos(@PathVariable Integer page) {
        Map<String, Object> response = new HashMap<>();
        Pageable pageable = PageRequest.of(page, 10);

        Page<Articulo> articulos;
        try {
            articulos = articuloService.findAll(pageable);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar la consulta en la base de datos.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (articulos.getSize() == 0) {
            response.put("mensaje", "No existen articulos en la base de datos.");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        response.put("Lista", articulos);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/articulos")
    public ResponseEntity<?> getArticulos() {

        List<Articulo> articulos;
        Map<String, Object> response = new HashMap<>();

        try {
            articulos = articuloService.findAllOrdenadosNombre();
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
    public ResponseEntity<?> getArticulo(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        Articulo articulo;
        try {
            articulo = articuloService.findById(id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al acceder al artículo en la base de datos.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (articulo == null) {
            response.put("mensaje", "El artículo solicitado no existe en la base de datos");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

        response.put("articulo", articulo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/articulos")
    public ResponseEntity<?> crearArticulo(@RequestBody Articulo articulo) {
        Map<String, Object> response = new HashMap<>();
        Articulo articuloNuevo;

        try {
            articuloNuevo = articuloService.save(articulo);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al realizar inserción en la base de datos");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "Artículo cread con éxito.");
        response.put("articulo", articuloNuevo);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/articulos/{id}")
    public ResponseEntity<?> modificarArticulo(@RequestBody Articulo articulo, @PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        Articulo articuloActualizado;

        try {
            articuloActualizado = articuloService.update(articulo, id);
        } catch (DataAccessException e) {
            response.put("mensaje", "Error al actualizar artículo en la base de datos.");
            response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        response.put("mensaje", "Artículo actualizado con éxito.");
        response.put("articulo", articuloActualizado);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/articulos/estado/{id}")
    public Articulo cambiarEstadoArticulo(@RequestBody Articulo articulo, @PathVariable Long id) {
        return articuloService.cambiarEstado(articulo, id);
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
