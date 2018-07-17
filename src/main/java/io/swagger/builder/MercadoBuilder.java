package io.swagger.builder;

import io.swagger.model.Mercado;
import io.swagger.model.Portafolio;

/**
 * @author luiscocr
 *
 */
public class MercadoBuilder {
    private String idMercado = null;
    private String nombre = null;
    private String sector = null;
    private String descripcion = null;

    public MercadoBuilder() {
    }

    public MercadoBuilder(String idMercado, String nombre, String sector, String descripcion) {
        this.idMercado = idMercado;
        this.nombre = nombre;
        this.sector = sector;
        this.descripcion = descripcion;
    }

    public MercadoBuilder conIdMercado(String idMercado) {
        this.idMercado = idMercado;
        return this;
    }

    public MercadoBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public MercadoBuilder conSector(String sector) {
        this.sector = sector;
        return this;
    }

    public MercadoBuilder conDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Mercado builder(){
        Mercado mercado = new Mercado();
        mercado.setIdMercado(idMercado);
        mercado.setNombre(nombre);
        mercado.setSector(sector);
        mercado.setDescripcion(descripcion);
        return mercado;
    }
}