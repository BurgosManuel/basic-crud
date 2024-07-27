package com.example.trapecioinv.service;

import com.example.trapecioinv.domain.dto.PersonDto;

import java.util.List;

public interface PersonService {
    public void savePerson(PersonDto personDto);
    public void updatePerson(PersonDto personDto);
    public void deletePerson(Long id);
    public PersonDto findPerson(Long id);
}
