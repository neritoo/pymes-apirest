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

    // Capitalizados para matchear con los que hicieron el backend de la catedra (dudoso)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdArticuloFamilia;

    private String Nombre;

    public ArticuloFamilia() {

    }

    public ArticuloFamilia(Long idArticuloFamilia, String nombre) {
        IdArticuloFamilia = idArticuloFamilia;
        Nombre = nombre;
    }

    public Long getIdArticuloFamilia() {
        return IdArticuloFamilia;
    }

    public void setIdArticuloFamilia(Long idArticuloFamilia) {
        IdArticuloFamilia = idArticuloFamilia;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    @Override
    public String toString() {
        return "ArticuloFamilia{" +
                "IdArticuloFamilia=" + IdArticuloFamilia +
                ", Nombre='" + Nombre + '\'' +
                '}';
    }
}
