package io.swagger.api;

import io.swagger.dominio.Dominio;
import io.swagger.model.Inversion;
import io.swagger.model.Portafolio;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
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
public class PortafolioApiController implements PortafolioApi {

    private static final Logger log = LoggerFactory.getLogger(PortafolioApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public PortafolioApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Portafolio> agregarPortafolio(@ApiParam(value = "Portafolio a agregar"  )  @Valid @RequestBody Portafolio portafolio) {
        Dominio.agregarPortafolio(portafolio);
        return new ResponseEntity<Portafolio>(portafolio, HttpStatus.OK);
    }

    public ResponseEntity<Portafolio> buscarPortafolio(@ApiParam(value = "Id del portafolio a buscar",required=true) @PathVariable("idPortafolio") String idPortafolio) {
        //DTO
        Portafolio portafolio = Dominio.getPortafolio(idPortafolio);

        if(portafolio == null){
            return new ResponseEntity<Portafolio>(HttpStatus.NOT_FOUND);
        }

        portafolio.getLinks().clear();
        portafolio.add(linkTo(PortafolioApi.class).slash(idPortafolio).withSelfRel());
        List<Inversion> linkBuilder = methodOn(PortafolioApiController.class).listarInversiones(idPortafolio);
        Link inversionesLink = linkTo(linkBuilder).withRel("todasInversiones");
        portafolio.add(inversionesLink);


        //Headers
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setExpires(1000);
        responseHeaders.set("Mi header", "valor x");

        return new ResponseEntity<Portafolio>(portafolio,responseHeaders,HttpStatus.OK);
    }

    public ResponseEntity<Void> eliminarPortafolio(@ApiParam(value = "Portafolio a ser eliminado",required=true) @PathVariable("idPortafolio") String idPortafolio) {
        return Dominio.eliminarPortafolio(idPortafolio)?
                new ResponseEntity<Void>(HttpStatus.OK)
                :
                new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

    public @ResponseBody List<Inversion> listarInversiones(@PathVariable("idPortafolio") String idPortafolio){
        List<Inversion> lstResponse = Dominio.listaInversiones(idPortafolio);
        for(Inversion inversion:lstResponse){
            inversion.getLinks().clear();
            Link inversionLink = linkTo(InversionApi.class).slash(inversion.getIdInversion()).withSelfRel();
            inversion.add(inversionLink);
        }
        return lstResponse;
    }

    public @ResponseBody List<Portafolio> consultarInversiones(@RequestParam("valor") Integer valor){
        List<Portafolio> lstResponse = Dominio.buscarPortafolio(valor);
        for(Portafolio portafolio:lstResponse){
            portafolio.getLinks().clear();
            Link portafolioLink = linkTo(PortafolioApi.class).slash(portafolio.getIdPortafolio()).withSelfRel();
            portafolio.add(portafolioLink);
        }
        return lstResponse;
    }
}
