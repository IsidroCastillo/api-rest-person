package com.iscastillo.api.person.service.impl;

import com.iscastillo.api.person.model.dto.PersonDto;
import com.iscastillo.api.person.model.repository.PersonRepository;
import com.iscastillo.api.person.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<PersonDto> getAll() {
        return (List<PersonDto>) personRepository.findAll();
    }

    @Override
    public PersonDto create(PersonDto personDto) {
        return personRepository.save(personDto);
    }

    @Override
    public Optional<PersonDto> findPersonbyEmail(String email) {
        Optional<PersonDto> personDto = personRepository.findByEmail(email);
        return personDto;
    }
}
