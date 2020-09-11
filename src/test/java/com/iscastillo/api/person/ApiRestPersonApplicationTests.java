package com.iscastillo.api.person;

import com.iscastillo.api.person.model.dto.PersonDto;
import com.iscastillo.api.person.service.PersonService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@ContextConfiguration
class ApiRestPersonApplicationTests {

    private static Logger logger = LogManager.getLogger(ApiRestPersonApplicationTests.class);

    @Autowired
    private PersonService personService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void registerPerson() {
        PersonDto personDto = new PersonDto();
        personDto.setFirstName("Isidro");
        personDto.setSecondName("");
        personDto.setSurname("Castillo");
        personDto.setSecondSurname("Muñoz");
        personDto.setRegistrationDate("2020-09-10");
        personDto.setSex("Masculino");
        personDto.setPhoneNumber("942661418");
        personDto.setAddress("Av. Las Magnolias");
        personDto.setNationality("Peruana");
        personDto.setDateBirth("1992-10-10");
        personDto.setEmail("iscastillo618@gmail.com");
        personDto.setPassword(passwordEncoder.encode("123456"));
        PersonDto findPerson = personService.create(personDto);
        Assert.state(findPerson != null, "Update failed");
    }

    @Test
    void findAll() {
        List<PersonDto> list = (List<PersonDto>) personService.getAll();
        list.stream().forEach(c -> ApiRestPersonApplicationTests.logger.info(c.toString()));
        Assert.notNull(list, "List is null");
        Assert.notEmpty(list, "List is empty");
    }

    @Test
    void findPersonByEmail() {
        String email = "iscastillo618@gmail.com";
        Optional<PersonDto> personDto = personService.findPersonbyEmail(email);
        Assert.state(personDto != null, "Person null");
    }

}
