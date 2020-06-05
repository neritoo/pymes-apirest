package com.gavilan.pymesapirest.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Ezequiel Gavilán
 */

@Entity
@Table(name = "articulos")
public class Articulo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdArticulo;

    private String Nombre;

    private Double Precio;

    private String CodigoDeBarra;

    private Long Stock;

    private Date FechaAlta;

    private boolean Activo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "IdArticuloFamilia")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private ArticuloFamilia ArticulosFamilia;

    public Articulo() {

    }

    public Articulo(Long idArticulo, String nombre, Double precio, String codigoDeBarra, Long stock, Date fechaAlta, boolean activo) {
        IdArticulo = idArticulo;
        Nombre = nombre;
        Precio = precio;
        CodigoDeBarra = codigoDeBarra;
        Stock = stock;
        FechaAlta = fechaAlta;
        Activo = activo;
    }

    public Long getIdArticulo() {
        return IdArticulo;
    }

    public void setIdArticulo(Long idArticulo) {
        IdArticulo = idArticulo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double precio) {
        Precio = precio;
    }

    public String getCodigoDeBarra() {
        return CodigoDeBarra;
    }

    public void setCodigoDeBarra(String codigoDeBarra) {
        CodigoDeBarra = codigoDeBarra;
    }

    public Long getStock() {
        return Stock;
    }

    public void setStock(Long stock) {
        Stock = stock;
    }

    public Date getFechaAlta() {
        return FechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        FechaAlta = fechaAlta;
    }

    public boolean isActivo() {
        return Activo;
    }

    public void setActivo(boolean activo) {
        Activo = activo;
    }

    public ArticuloFamilia getArticulosFamilia() {
        return ArticulosFamilia;
    }

    public void setArticulosFamilia(ArticuloFamilia articulosFamilia) {
        ArticulosFamilia = articulosFamilia;
    }

    @Override
    public String toString() {
        return "Articulo{" +
                "IdArticulo=" + IdArticulo +
                ", Nombre='" + Nombre + '\'' +
                ", Precio=" + Precio +
                ", CodigoDeBarra='" + CodigoDeBarra + '\'' +
                ", Stock=" + Stock +
                ", FechaAlta=" + FechaAlta +
                ", Activo=" + Activo +
                '}';
    }

}
