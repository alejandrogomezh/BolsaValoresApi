package io.swagger.api;

import io.swagger.dominio.Dominio;
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

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    public ResponseEntity<Mercado> agregarMercado(@ApiParam(value = "Mercado a agregar"  )  @Valid @RequestBody Mercado mercado) {
        Dominio.agregarMercado(mercado);
        return new ResponseEntity<Mercado>(mercado, HttpStatus.OK);
    }

    public ResponseEntity<Mercado> buscarMercado(@ApiParam(value = "Id del mercado a buscar",required=true) @PathVariable("idMercado") String idMercado) {
        //DTO
        Mercado mercado = Dominio.getMercado(idMercado);

        if(mercado == null){
            return new ResponseEntity<Mercado>(HttpStatus.NOT_FOUND);
        }

        mercado.getLinks().clear();
        mercado.add(linkTo(MercadoApi.class).slash(idMercado).withSelfRel());
        List<Portafolio> linkBuilder = methodOn(MercadoApiController.class).listarPortafolio(idMercado);
        Link portafoliosLink = linkTo(linkBuilder).withRel("todosPortafolios");
        mercado.add(portafoliosLink);

        //Headers
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setExpires(1000);
        responseHeaders.set("Mi header", "valor x");

        return new ResponseEntity<Mercado>(mercado,responseHeaders,HttpStatus.OK);
    }

    public ResponseEntity<Void> eliminarMercado(@ApiParam(value = "Mercado a ser eliminado",required=true) @PathVariable("idMercado") String idMercado) {
        return Dominio.eliminarMercado(idMercado)?
             new ResponseEntity<Void>(HttpStatus.OK)
        :
             new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    public @ResponseBody List<Portafolio> listarPortafolio(@PathVariable("idMercado") String idMercado){
        List<Portafolio> lstResponse = Dominio.listaPortafolios(idMercado);

        for(Portafolio portafolio:lstResponse){
            portafolio.getLinks().clear();
            Link portafolioLink = linkTo(PortafolioApi.class).slash(portafolio.getIdPortafolio()).withSelfRel();
            portafolio.add(portafolioLink);
        }
        return lstResponse;
    }
}
