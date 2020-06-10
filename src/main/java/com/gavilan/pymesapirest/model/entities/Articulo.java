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
    private Long id;

    private String nombre;

    private Double precio;

    @Column(name = "codigo_barra")
    private String codigoBarra;

    private Long stock;

    @Column(name = "fecha_alta")
    private Date fechaAlta;

    private boolean activo;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_articulo_familia")
    private ArticuloFamilia ArticulosFamilia;

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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
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
                "IdArticulo=" + id +
                ", Nombre='" + nombre + '\'' +
                ", Precio=" + precio +
                ", CodigoDeBarra='" + codigoBarra + '\'' +
                ", Stock=" + stock +
                ", FechaAlta=" + fechaAlta +
                ", Activo=" + activo +
                '}';
    }

}
