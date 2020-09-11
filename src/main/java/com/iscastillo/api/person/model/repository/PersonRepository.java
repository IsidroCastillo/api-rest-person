package com.iscastillo.api.person.model.repository;

import com.iscastillo.api.person.model.dto.PersonDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonRepository extends CrudRepository<PersonDto, Integer> {
    Optional<PersonDto> findByEmail(String email);
}
