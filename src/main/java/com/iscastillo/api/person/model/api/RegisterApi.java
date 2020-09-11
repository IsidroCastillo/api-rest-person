package com.iscastillo.api.person.model.api;

import com.iscastillo.api.person.model.dto.PersonDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@Validated
@EnableSwagger2
@Api(value = "PersonConfiguration")
public interface RegisterApi {
    // sirve para brindar información de lo que trata
    @ApiOperation(value = "Retorna todas las personas", nickname = "findAllPerson", notes = "Mostrar todas las personas",
            response = PersonDto.class, responseContainer = "List", tags = {"PersononfigurationBackOffice"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operacion realizada corrctamente", response = PersonDto.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Request esta mal escrito no puede procesarlo "),
            @ApiResponse(code = 500, message = "Error interno")
    })
    @RequestMapping(value = "/process/find",
            produces = {"application/json"},
            method = RequestMethod.GET)
    default ResponseEntity<List<PersonDto>> findAllPerson() {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @ApiOperation(value = "RRegistra una persona", nickname = "crearte", notes = "Mostrar todas las personas",
            response = PersonDto.class, responseContainer = "List", tags = {"PersononfigurationBackOffice"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operacion realizada corrctamente", response = PersonDto.class, responseContainer = "List"),
            @ApiResponse(code = 400, message = "Request esta mal escrito no puede procesarlo "),
            @ApiResponse(code = 500, message = "Error interno")
    })
    @RequestMapping(value = "/process/create",
            produces = {"application/json"},
            method = RequestMethod.POST)
    default ResponseEntity<List<PersonDto>> crearte(@RequestBody PersonDto person) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
