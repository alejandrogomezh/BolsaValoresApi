package io.swagger.api;

import io.swagger.configuration.Utiles;
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
import java.util.stream.Collectors;

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

    public ResponseEntity<Void> agregarPortafolio(@ApiParam(value = "Id del portafolio a agregar",required=true) @PathVariable("idPortafolio") String idPortafolio,@ApiParam(value = "Portafolio a agregar"  )  @Valid @RequestBody Portafolio portafolio) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Portafolio> buscarPortafolio(@ApiParam(value = "Id del portafolio a buscar",required=true) @PathVariable("idPortafolio") String idPortafolio) {
        //DTO
        Portafolio portafolio = Utiles.listaPortafolio()
                .stream().filter(m -> m.getIdPortafolio().equals(idPortafolio))
                .findFirst()
                .get();

        portafolio.add(linkTo(PortafolioApi.class).slash(portafolio.getIdPortafolio()).withSelfRel());

        //Asignar referencia a cotejos
        List<Inversion> linkBuilder = methodOn(PortafolioApiController.class).listarInversiones(portafolio.getIdPortafolio());
        Link inversionesLink = linkTo(linkBuilder).withRel("todasInversiones");
        portafolio.add(inversionesLink);

        //Headers
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setExpires(1000);
        responseHeaders.set("Mi header", "valor x");

        return new ResponseEntity<Portafolio>(portafolio,responseHeaders,HttpStatus.OK);
    }

    public ResponseEntity<Void> eliminarPortafolio(@ApiParam(value = "Portafolio a ser eliminado",required=true) @PathVariable("idPortafolio") String idPortafolio) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public @ResponseBody List<Inversion> listarInversiones(@PathVariable("idPortafolio") String idPortafolio){
        List<Inversion> lstResponse = Utiles.listaInversiones()
                .stream().filter(m -> m.getIdPortafolio().equals(idPortafolio))
                .collect(Collectors.toList());
        for(Inversion inversion:lstResponse){
            Link inversionLink = linkTo(Inversion.class).slash("inversion").slash(inversion.getIdInversion()).withSelfRel();
            inversion.add(inversionLink);
        }
        return lstResponse;
    }

}
