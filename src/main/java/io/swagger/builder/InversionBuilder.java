package io.swagger.builder;

import io.swagger.model.Inversion;
import io.swagger.model.Mercado;
import io.swagger.model.Portafolio;

/**
 * @author luiscocr
 *
 */
public class InversionBuilder {
    private String idInversion = null;
    private String idPortafolio = null;
    private Integer cantidadAcciones = null;

    public InversionBuilder() {

    }

    public InversionBuilder(String idInversion, String idPortafolio, Integer cantidadAcciones) {
        this.idInversion = idInversion;
        this.idPortafolio = idPortafolio;
        this.cantidadAcciones = cantidadAcciones;
    }

    public InversionBuilder conIdInversion(String idInversion) {
        this.idInversion = idInversion;
        return this;
    }

    public InversionBuilder conIdPortafolio(String idPortafolio) {
        this.idPortafolio = idPortafolio;
        return this;
    }

    public InversionBuilder conCantidadAcciones(Integer cantidadAcciones) {
        this.cantidadAcciones = cantidadAcciones;
        return this;
    }

    public Inversion builder(){
        Inversion inversion = new Inversion();
        inversion.setIdInversion(idInversion);
        inversion.setIdPortafolio(idPortafolio);
        inversion.setCantidadAcciones(cantidadAcciones);
        return inversion;
    }
}