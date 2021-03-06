package io.swagger.builder;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.model.Mercado;
import io.swagger.model.Portafolio;

/**
 * @author luiscocr
 *
 */
public class PortafolioBuilder {

    private String idPortafolio;
    private String idMercado;
    private String nombre;
    private Integer rentabilidad;
    private Integer cantidadAcciones;
    private Integer valorAccion;
    private String estado;

    public PortafolioBuilder() {
    }

    public PortafolioBuilder(String idPortafolio, String idMercado, String nombre, Integer rentabilidad,
                             Integer cantidadAcciones, Integer valorAccion, String estado) {
        this.idPortafolio = idPortafolio;
        this.idMercado = idMercado;
        this.nombre = nombre;
        this.rentabilidad = rentabilidad;
        this.cantidadAcciones = cantidadAcciones;
        this.valorAccion = valorAccion;
        this.estado = estado;
    }

    public PortafolioBuilder conIdPortafolio(String idPortafolio) {
        this.idPortafolio = idPortafolio;
        return this;
    }
    public PortafolioBuilder conIdMercado(String idMercado) {
        this.idMercado = idMercado;
        return this;
    }
    public PortafolioBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    public PortafolioBuilder conRentabilidad(Integer rentabilidad) {
        this.rentabilidad = rentabilidad;
        return this;
    }
    public PortafolioBuilder conCantidadAcciones(Integer cantidadAcciones) {
        this.cantidadAcciones = cantidadAcciones;
        return this;
    }
    public PortafolioBuilder conValorAccion(Integer valorAccion) {
        this.valorAccion = valorAccion;
        return this;
    }
    public PortafolioBuilder conEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public Portafolio build() {
        Portafolio portafolio = new Portafolio();

        portafolio.setIdPortafolio(this.idPortafolio);
        portafolio.setIdMercado(this.idMercado);
        portafolio.setNombre(this.nombre);
        portafolio.setRentabilidad(this.rentabilidad);
        portafolio.setCantidadAcciones(this.cantidadAcciones);
        portafolio.setValorAccion(this.valorAccion);
        portafolio.setEstado(this.estado);

        return portafolio;
    }

}