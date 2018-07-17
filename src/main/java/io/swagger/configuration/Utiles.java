package io.swagger.configuration;

import io.swagger.builder.InversionBuilder;
import io.swagger.builder.MercadoBuilder;
import io.swagger.builder.PortafolioBuilder;
import io.swagger.model.Inversion;
import io.swagger.model.Mercado;
import io.swagger.model.Portafolio;

import java.util.ArrayList;
import java.util.List;

public class Utiles {

    static{

    }

    public static List<Mercado> listaMercado(){
        List<Mercado> lst = new ArrayList<>();
        lst.add(new MercadoBuilder()
                .conIdMercado("m1")
                .conNombre("mercado 1")
                .conDescripcion("mercado 1")
                .conSector("agricola")
                .builder());
        lst.add(new MercadoBuilder()
                .conIdMercado("m2")
                .conNombre("mercado 2")
                .conDescripcion("mercado 2")
                .conSector("mineria")
                .builder());
        return  lst;
    }

    public static List<Portafolio> listaPortafolio(){
        List<Portafolio> lst = new ArrayList<>();
        lst.add(new PortafolioBuilder()
                .conIdPortafolio("p1")
                .conIdMercado("m1")
                .conNombre("Portafolio 1")
                .conCantidadAcciones(23)
                .conEstado("Abierto")
                .conRentabilidad(10)
                .conValorAccion(100000)
                .build());
        lst.add(new PortafolioBuilder()
                .conIdPortafolio("p2")
                .conIdMercado("m1")
                .conNombre("Portafolio 2")
                .conCantidadAcciones(23)
                .conEstado("Abierto")
                .conRentabilidad(10)
                .conValorAccion(100000)
                .build());
        lst.add(new PortafolioBuilder()
                .conIdPortafolio("p3")
                .conIdMercado("m2")
                .conNombre("Portafolio 3")
                .conCantidadAcciones(23)
                .conEstado("Abierto")
                .conRentabilidad(10)
                .conValorAccion(100000)
                .build());
        lst.add(new PortafolioBuilder()
                .conIdPortafolio("p4")
                .conIdMercado("m2")
                .conNombre("Portafolio 4")
                .conCantidadAcciones(23)
                .conEstado("Abierto")
                .conRentabilidad(10)
                .conValorAccion(100000)
                .build());
        return  lst;
    }

    public static List<Inversion> listaInversiones(){
        List<Inversion> lst = new ArrayList<>();
        lst.add(new InversionBuilder()
                .conIdInversion("i1")
                .conIdPortafolio("p1")
                .conCantidadAcciones(11)
                .builder());
        lst.add(new InversionBuilder()
                .conIdInversion("i2")
                .conIdPortafolio("p1")
                .conCantidadAcciones(12)
                .builder());
        lst.add(new InversionBuilder()
                .conIdInversion("i3")
                .conIdPortafolio("p2")
                .conCantidadAcciones(13)
                .builder());
        lst.add(new InversionBuilder()
                .conIdInversion("i4")
                .conIdPortafolio("p2")
                .conCantidadAcciones(14)
                .builder());
        lst.add(new InversionBuilder()
                .conIdInversion("i5")
                .conIdPortafolio("p3")
                .conCantidadAcciones(15)
                .builder());
        lst.add(new InversionBuilder()
                .conIdInversion("i6")
                .conIdPortafolio("p3")
                .conCantidadAcciones(16)
                .builder());
        lst.add(new InversionBuilder()
                .conIdInversion("i7")
                .conIdPortafolio("p4")
                .conCantidadAcciones(17)
                .builder());
        lst.add(new InversionBuilder()
                .conIdInversion("i8")
                .conIdPortafolio("p4")
                .conCantidadAcciones(18)
                .builder());
        return  lst;
    }

}
