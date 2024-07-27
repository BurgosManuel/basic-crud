package com.example.trapecioinv.service.impl;

import com.example.trapecioinv.domain.dto.PersonDto;
import com.example.trapecioinv.repository.PersonRepository;
import com.example.trapecioinv.service.PersonService;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    protected PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @Override
    public void savePerson(PersonDto personDto) {

    }

    @Override
    public void updatePerson(PersonDto personDto) {

    }

    @Override
    public void deletePerson(Long id) {

    }

    @Override
    public PersonDto findPerson(Long id) {
        return null;
    }
}
