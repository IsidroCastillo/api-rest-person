package com.iscastillo.api.person.service;

import com.iscastillo.api.person.model.dto.PersonDto;
import org.springframework.security.access.annotation.Secured;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    @Secured({ "ROLE_USER" })
    List<PersonDto> getAll();

    PersonDto create(PersonDto personDto);

    Optional<PersonDto>findPersonbyEmail(String email);
}
