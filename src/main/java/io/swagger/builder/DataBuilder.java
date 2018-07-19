package io.swagger.builder;

import io.swagger.model.Inversion;
import io.swagger.model.Mercado;
import io.swagger.model.Portafolio;

import java.util.ArrayList;
import java.util.List;

public class DataBuilder {
    private static List<Mercado> listaMercados = new ArrayList<>();
    private static List<Portafolio> listaPortafolios = new ArrayList<>();
    private static List<Inversion> listaInversiones = new ArrayList<>();

    public static List<Mercado> listaMercados(){
        return listaMercados;
    }
    public static void cargarMercados(){
        listaMercados.add(new MercadoBuilder()
                .conIdMercado("m1")
                .conNombre("mercado 1")
                .conDescripcion("mercado 1")
                .conSector("agricola")
                .builder());
        listaMercados.add(new MercadoBuilder()
                .conIdMercado("m2")
                .conNombre("mercado 2")
                .conDescripcion("mercado 2")
                .conSector("mineria")
                .builder());
    }

    public static List<Portafolio> listaPortafolios(){ return listaPortafolios; }
    public static void cargarPortafolios(){
        listaPortafolios.add(new PortafolioBuilder()
                .conIdPortafolio("p1")
                .conIdMercado("m1")
                .conNombre("Portafolio 1")
                .conCantidadAcciones(23)
                .conEstado("Abierto")
                .conRentabilidad(10)
                .conValorAccion(100000)
                .build());
        listaPortafolios.add(new PortafolioBuilder()
                .conIdPortafolio("p2")
                .conIdMercado("m1")
                .conNombre("Portafolio 2")
                .conCantidadAcciones(23)
                .conEstado("Abierto")
                .conRentabilidad(10)
                .conValorAccion(200000)
                .build());
        listaPortafolios.add(new PortafolioBuilder()
                .conIdPortafolio("p3")
                .conIdMercado("m2")
                .conNombre("Portafolio 3")
                .conCantidadAcciones(23)
                .conEstado("Abierto")
                .conRentabilidad(10)
                .conValorAccion(300000)
                .build());
        listaPortafolios.add(new PortafolioBuilder()
                .conIdPortafolio("p4")
                .conIdMercado("m2")
                .conNombre("Portafolio 4")
                .conCantidadAcciones(23)
                .conEstado("Abierto")
                .conRentabilidad(10)
                .conValorAccion(400000)
                .build());
    }

    public static List<Inversion> listaInversiones(){
        return listaInversiones;
    }
    public static void cargarInversiones(){
        listaInversiones.add(new InversionBuilder()
                .conIdInversion("i1")
                .conIdPortafolio("p1")
                .conCantidadAcciones(11)
                .builder());
        listaInversiones.add(new InversionBuilder()
                .conIdInversion("i2")
                .conIdPortafolio("p1")
                .conCantidadAcciones(12)
                .builder());
        listaInversiones.add(new InversionBuilder()
                .conIdInversion("i3")
                .conIdPortafolio("p2")
                .conCantidadAcciones(13)
                .builder());
        listaInversiones.add(new InversionBuilder()
                .conIdInversion("i4")
                .conIdPortafolio("p2")
                .conCantidadAcciones(14)
                .builder());
        listaInversiones.add(new InversionBuilder()
                .conIdInversion("i5")
                .conIdPortafolio("p3")
                .conCantidadAcciones(15)
                .builder());
        listaInversiones.add(new InversionBuilder()
                .conIdInversion("i6")
                .conIdPortafolio("p3")
                .conCantidadAcciones(16)
                .builder());
        listaInversiones.add(new InversionBuilder()
                .conIdInversion("i7")
                .conIdPortafolio("p4")
                .conCantidadAcciones(17)
                .builder());
        listaInversiones.add(new InversionBuilder()
                .conIdInversion("i8")
                .conIdPortafolio("p4")
                .conCantidadAcciones(18)
                .builder());
    }

}
