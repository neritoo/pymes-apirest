package com.gavilan.pymesapirest.model.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Ezequiel Gavilán
 */

@Entity
@Table(name = "articulos_familia")
public class ArticuloFamilia implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "ArticuloFamilia{" +
                "IdArticuloFamilia=" + id +
                ", Nombre='" + nombre + '\'' +
                '}';
    }
}
