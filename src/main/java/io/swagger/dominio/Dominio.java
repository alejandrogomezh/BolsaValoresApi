package io.swagger.dominio;

import io.swagger.builder.InversionBuilder;
import io.swagger.builder.MercadoBuilder;
import io.swagger.builder.PortafolioBuilder;
import io.swagger.model.Inversion;
import io.swagger.model.Mercado;
import io.swagger.model.Portafolio;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Dominio {
    private static int mercadoCount;
    private static int portafolioCount;
    private static int inversionCount;

    private static List<Mercado> listaMercados;
    private static List<Portafolio> listaPortafolios;
    private static List<Inversion> listaInversiones;

    static{
        cargarMercados();
        cargarPortafolios();
        cargarInversiones();
        mercadoCount = listaMercados().size();
        portafolioCount = listaPortafolios().size();
        inversionCount = listaInversiones().size();
    }

    public void create(){
        ObjectMapper mapper = new ObjectMapper(); // create once, reuse

/*
        ObjectWriter writer = mapper.writer();
        List<MercadoDominio> lst = new ArrayList<>();
        lst.add(new MercadoDominio("1","2","2","2").setPortafolio(new ArrayList<>()));
        String out = "";
        try {
            out = writer.writeValueAsString(lst);
        }catch (com.fasterxml.jackson.core.JsonParseException e){
            System.out.print(e);
        }catch (java.io.IOException e){
            System.out.print(e);
        }
 */
        ClassLoader classLoader = Dominio.class.getClassLoader().getSystemClassLoader();//getClass().getClassLoader();
        File file = new File(classLoader.getResource("BolsaValoresDominio.json").getFile());
        Mercado[] value = new Mercado[0];
        try {
            value = mapper.readValue(file, Mercado[].class);
        }catch (com.fasterxml.jackson.core.JsonParseException e){
            System.out.print(e);
        }catch (java.io.IOException e){
            System.out.print(e);
        }
        String name = value[0].getNombre();
        if(name == null){

        }
    }

    public static List<Mercado> listaMercados(){
        return listaMercados;
    }
    public static void cargarMercados(){
        listaMercados = new ArrayList<>();
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

    public static List<Portafolio> listaPortafolios(String idMercado){
        return listaPortafolios
                .stream().filter(m -> m.getIdMercado().equals(idMercado))
                .collect(Collectors.toList());
    }

    public static List<Portafolio> listaPortafolios(){
        return listaPortafolios;
    }
    public static void cargarPortafolios(){
        listaPortafolios = new ArrayList<>();
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

    public static List<Inversion> listaInversiones(String idPortafolio){
        return listaInversiones
                .stream()
                .filter(m -> m.getIdPortafolio().equals(idPortafolio))
                .collect(Collectors.toList());
    }

    public static List<Portafolio> buscarPortafolio(Integer valor){
        return listaPortafolios
                .stream()
                .filter(m -> m.getValorAccion() <= valor)
                .collect(Collectors.toList());
    }

    public static List<Inversion> listaInversiones(){
        return listaInversiones;
    }
    public static void cargarInversiones(){
        listaInversiones = new ArrayList<>();
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

    public static void agregarMercado(Mercado mercado){
        mercado.setIdMercado("m"+mercadoCount);
        listaMercados.add(mercado);
        mercadoCount++;
    }

    public static void agregarPortafolio(Portafolio portafolio){
        portafolio.setIdPortafolio("p"+portafolioCount);
        listaPortafolios.add(portafolio);
        portafolioCount++;
    }

    public static void agregarInversion(Inversion inversion){
        inversion.setIdInversion("i"+inversionCount);
        listaInversiones.add(inversion);
        inversionCount++;
    }

    public static Mercado getMercado(String idMercado){
        try {
            return listaMercados
                    .stream().filter(m -> m.getIdMercado().equals(idMercado))
                    .findFirst()
                    .get();
        }catch (Exception e){
            return null;
        }

    }

    public static Portafolio getPortafolio(String idPortafolio){
        try {
            return listaPortafolios
                    .stream().filter(m -> m.getIdPortafolio().equals(idPortafolio))
                    .findFirst()
                    .get();
        }catch (Exception e){
            return null;
        }
    }

    public static Inversion getInversion(String idInversion){
        try {
            return listaInversiones
                    .stream().filter(m -> m.getIdInversion().equals(idInversion))
                    .findFirst()
                    .get();
        }catch (Exception e){
            return null;
        }
    }

    public static boolean eliminarMercado(String idMercado){
        eliminarInversionDesdeMercado(idMercado);
        eliminarPortafolioDesdeMercado(idMercado);
        return listaMercados
                .removeIf(m -> m.getIdMercado().equals(idMercado));
    }

    public static boolean eliminarPortafolio(String idPortafolio){
        eliminarInversionDesdePortafolio(idPortafolio);
        return listaPortafolios
                .removeIf(p -> p.getIdPortafolio().equals(idPortafolio));
    }

    public static boolean eliminarInversion(String idInversion){
        return listaInversiones
                .removeIf(i -> i.getIdInversion().equals(idInversion));
    }

    private static void eliminarPortafolioDesdeMercado(String idMercado){
        listaPortafolios
                .removeIf(p -> p.getIdMercado().equals(idMercado));
    }

    private static void eliminarInversionDesdeMercado(String idMercado){
        listaPortafolios
                .stream().filter(m -> m.getIdMercado().equals(idMercado))
                .collect(Collectors.toList()).forEach(p -> {
            eliminarInversionDesdePortafolio(p.getIdPortafolio());
        });
    }

    private static void eliminarInversionDesdePortafolio(String idPortafolio){
        listaInversiones
                .removeIf(i -> i.getIdPortafolio().equals(idPortafolio));
    }




}
