package io.swagger.api;

import io.swagger.configuration.Utiles;
import io.swagger.model.Inversion;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;

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

    public ResponseEntity<Void> agregarInversion(@ApiParam(value = "Id de la inversión a agregar",required=true) @PathVariable("idInversion") String idInversion,@ApiParam(value = "Inversión a agregar"  )  @Valid @RequestBody Inversion inversion) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Inversion> buscarInversion(@ApiParam(value = "Id de la inversión a buscar",required=true) @PathVariable("idInversion") String idInversion) {
        //DTO
        Inversion inversion = Utiles.listaInversiones()
                .stream().filter(m -> m.getIdInversion().equals(idInversion))
                .findFirst()
                .get();

        //Headers
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setExpires(1000);
        responseHeaders.set("Mi header", "valor x");

        return new ResponseEntity<Inversion>(inversion,responseHeaders,HttpStatus.OK);
    }

    public ResponseEntity<Void> eliminarInversion(@ApiParam(value = "Inversión a ser eliminada",required=true) @PathVariable("idInversion") String idInversion) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
