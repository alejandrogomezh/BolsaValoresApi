package io.swagger.api;

import io.swagger.configuration.Utiles;
import io.swagger.model.Inversion;
import io.swagger.model.Mercado;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import io.swagger.model.Portafolio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Controller
public class MercadoApiController implements MercadoApi {

    private static final Logger log = LoggerFactory.getLogger(MercadoApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public MercadoApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> agregarMercado(@ApiParam(value = "Id del mercado a agregar",required=true) @PathVariable("idMercado") String idMercado,@ApiParam(value = "Mercado a agregar"  )  @Valid @RequestBody Mercado mercado) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Mercado> buscarMercado(@ApiParam(value = "Id del mercado a buscar",required=true) @PathVariable("idMercado") String idMercado) {
        //DTO
        Mercado mercado = Utiles.listaMercado()
                .stream().filter(m -> m.getIdMercado().equals(idMercado))
                .findFirst()
                .get();

        mercado.add(linkTo(PortafolioApi.class).slash(mercado.getIdMercado()).withSelfRel());

        //Asignar referencia a cotejos
        List<Inversion> linkBuilder = methodOn(PortafolioApiController.class).listarInversiones(mercado.getIdMercado());
        Link cotejosLink = linkTo(linkBuilder).withRel("todosPortafolios");
        mercado.add(cotejosLink);

        //Headers
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setExpires(1000);
        responseHeaders.set("Mi header", "valor x");

        return new ResponseEntity<Mercado>(mercado,responseHeaders,HttpStatus.OK);
    }

    public ResponseEntity<Void> eliminarMercado(@ApiParam(value = "Mercado a ser eliminado",required=true) @PathVariable("idMercado") String idMercado) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public @ResponseBody List<Portafolio> listarPortafolio(@PathVariable("idMercado") String idMercado){
        List<Portafolio> lstResponse = Utiles.listaPortafolio()
                .stream().filter(m -> m.getIdMercado().equals(idMercado))
                .collect(Collectors.toList());

        for(Portafolio portafolio:lstResponse){
            Link portafolioLink = linkTo(Portafolio.class).slash("portafolio").slash(portafolio.getIdPortafolio()).withSelfRel();
            portafolio.add(portafolioLink);
        }
        return lstResponse;
    }
}
