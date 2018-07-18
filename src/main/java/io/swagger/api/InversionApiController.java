package io.swagger.api;

import io.swagger.dominio.Dominio;
import io.swagger.model.Inversion;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Controller
public class InversionApiController implements InversionApi {

    private static final Logger log = LoggerFactory.getLogger(InversionApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public InversionApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Inversion> agregarInversion(@ApiParam(value = "Inversión a agregar"  )  @Valid @RequestBody Inversion inversion) {
        Dominio.agregarInversion(inversion);
        return new ResponseEntity<Inversion>(inversion, HttpStatus.OK);
    }

    public ResponseEntity<Inversion> buscarInversion(@ApiParam(value = "Id de la inversión a buscar",required=true) @PathVariable("idInversion") String idInversion) {
        //DTO
        Inversion inversion = Dominio.getInversion(idInversion);

        if(inversion == null){
            return new ResponseEntity<Inversion>(HttpStatus.NOT_FOUND);
        }


        inversion.getLinks().clear();
        inversion.add(linkTo(InversionApi.class).slash(inversion.getIdPortafolio()).withSelfRel());

        //Headers
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setExpires(1000);
        responseHeaders.set("Mi header", "valor x");

        return new ResponseEntity<Inversion>(inversion,responseHeaders,HttpStatus.OK);
    }

    public ResponseEntity<Void> eliminarInversion(@ApiParam(value = "Inversión a ser eliminada",required=true) @PathVariable("idInversion") String idInversion) {
        return Dominio.eliminarInversion(idInversion)?
                new ResponseEntity<Void>(HttpStatus.OK)
                :
                new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
    }

}
