package com.iscastillo.api.person.service.impl;

import com.iscastillo.api.person.model.dto.PersonDto;
import com.iscastillo.api.person.service.PersonService;
import com.iscastillo.api.person.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private PersonService personService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        PersonDto user = personService.findPersonbyEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(email));
        return UserService.build(user);
    }
}
