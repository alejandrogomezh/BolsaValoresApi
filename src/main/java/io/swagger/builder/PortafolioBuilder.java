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
    private Mercado mercado;

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

    public void withIdPortafolio(String idPortafolio) {
        this.idPortafolio = idPortafolio;
    }
    public void withIdMercado(String idMercado) {
        this.idMercado = idMercado;
    }
    public void withNombre(String nombre) {
        this.nombre = nombre;
    }
    public void withRentabilidad(Integer rentabilidad) {
        this.rentabilidad = rentabilidad;
    }
    public void withCantidadAcciones(Integer cantidadAcciones) {
        this.cantidadAcciones = cantidadAcciones;
    }
    public void withValorAccion(Integer valorAccion) {
        this.valorAccion = valorAccion;
    }
    public void withEstado(String estado) {
        this.estado = estado;
    }

    public Portafolio buildProtafolio() {
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