package io.swagger.dominio;

import io.swagger.builder.DataBuilder;
import io.swagger.model.Inversion;
import io.swagger.model.Mercado;
import io.swagger.model.Portafolio;

import java.util.List;
import java.util.stream.Collectors;

public class Dominio {
    private static int mercadoCount;
    private static int portafolioCount;
    private static int inversionCount;

    static{
        DataBuilder.cargarMercados();
        DataBuilder.cargarPortafolios();
        DataBuilder.cargarInversiones();
        mercadoCount = DataBuilder.listaMercados().size();
        portafolioCount = DataBuilder.listaPortafolios().size();
        inversionCount = DataBuilder.listaInversiones().size();
    }

    public static List<Portafolio> listaPortafolios(String idMercado){
        return DataBuilder.listaPortafolios()
                .stream().filter(m -> m.getIdMercado().equals(idMercado))
                .collect(Collectors.toList());
    }


    public static List<Inversion> listaInversiones(String idPortafolio){
        return DataBuilder.listaInversiones()
                .stream()
                .filter(m -> m.getIdPortafolio().equals(idPortafolio))
                .collect(Collectors.toList());
    }

    public static List<Portafolio> buscarPortafolio(Integer valor){
        return DataBuilder.listaPortafolios()
                .stream()
                .filter(m -> m.getValorAccion() <= valor)
                .collect(Collectors.toList());
    }

    public static void agregarMercado(Mercado mercado){
        mercado.setIdMercado("m"+mercadoCount);
        DataBuilder.listaMercados().add(mercado);
        mercadoCount++;
    }

    public static void agregarPortafolio(Portafolio portafolio){
        portafolio.setIdPortafolio("p"+portafolioCount);
        DataBuilder.listaPortafolios().add(portafolio);
        portafolioCount++;
    }

    public static void agregarInversion(Inversion inversion){
        inversion.setIdInversion("i"+inversionCount);
        DataBuilder.listaInversiones().add(inversion);
        inversionCount++;
    }

    public static Mercado getMercado(String idMercado){
        try {
            return DataBuilder.listaMercados()
                    .stream().filter(m -> m.getIdMercado().equals(idMercado))
                    .findFirst()
                    .get();
        }catch (Exception e){
            return null;
        }

    }

    public static Portafolio getPortafolio(String idPortafolio){
        try {
            return DataBuilder.listaPortafolios()
                    .stream().filter(m -> m.getIdPortafolio().equals(idPortafolio))
                    .findFirst()
                    .get();
        }catch (Exception e){
            return null;
        }
    }

    public static Inversion getInversion(String idInversion){
        try {
            return DataBuilder.listaInversiones()
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
        return DataBuilder.listaMercados()
                .removeIf(m -> m.getIdMercado().equals(idMercado));
    }

    public static boolean eliminarPortafolio(String idPortafolio){
        eliminarInversionDesdePortafolio(idPortafolio);
        return DataBuilder.listaPortafolios()
                .removeIf(p -> p.getIdPortafolio().equals(idPortafolio));
    }

    public static boolean eliminarInversion(String idInversion){
        return DataBuilder.listaInversiones()
                .removeIf(i -> i.getIdInversion().equals(idInversion));
    }

    private static void eliminarPortafolioDesdeMercado(String idMercado){
        DataBuilder.listaPortafolios()
                .removeIf(p -> p.getIdMercado().equals(idMercado));
    }

    private static void eliminarInversionDesdeMercado(String idMercado){
        DataBuilder.listaPortafolios()
                .stream().filter(m -> m.getIdMercado().equals(idMercado))
                .collect(Collectors.toList()).forEach(p -> {
            eliminarInversionDesdePortafolio(p.getIdPortafolio());
        });
    }

    private static void eliminarInversionDesdePortafolio(String idPortafolio){
        DataBuilder.listaInversiones()
                .removeIf(i -> i.getIdPortafolio().equals(idPortafolio));
    }




}
