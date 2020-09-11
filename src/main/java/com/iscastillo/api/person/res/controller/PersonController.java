package com.iscastillo.api.person.res.controller;

import com.iscastillo.api.person.model.api.RegisterApi;
import com.iscastillo.api.person.model.dto.PersonDto;
import com.iscastillo.api.person.service.PersonService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
//pedro.antonio.barreto.gonzales@everis.com
import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
@RestController
@RequiredArgsConstructor
public class PersonController implements RegisterApi {

    @NonNull
    private final PersonService personService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<PersonDto>> wellcomePerson(){
        List<PersonDto> list = this.personService.getAll();
        if (list.isEmpty()) {
            PersonController.log.error("Error: No Entity found");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            PersonController.log.error("Info: Entity found{}", list);
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }

    //Jwt Con tokens tambien se utiliza para encriptar el password
    @Autowired
    public ResponseEntity<List<PersonDto>> findAllPerson() {
        List<PersonDto> list = this.personService.getAll();
        if (list.isEmpty()) {
            PersonController.log.error("Error: No Entity found");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
//            PersonController.log.error("Info: Entity found{}", list);
            PersonController.log.error("Info: Entity found.");
            return new ResponseEntity<>(list, HttpStatus.OK);
        }

    }

    @Override
    public ResponseEntity<List<PersonDto>> crearte(@RequestBody PersonDto person) {
        try {
            this.personService.create(person);
            PersonController.log.error("info: Entity created{}", person);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            PersonController.log.error("Error: Created failed{}", person);
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }


}
