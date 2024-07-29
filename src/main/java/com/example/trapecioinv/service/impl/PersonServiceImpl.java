package com.example.trapecioinv.service.impl;

import com.example.trapecioinv.domain.dto.PersonDto;
import com.example.trapecioinv.domain.entities.Person;
import com.example.trapecioinv.repository.PersonRepository;
import com.example.trapecioinv.service.PersonService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    protected PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    @Override
    public void savePerson(PersonDto personDto) {
        Person person = new Person();
        BeanUtils.copyProperties(personDto, person);
        this.personRepository.save(person);
    }

    @Override
    public void updatePerson(PersonDto personDto) {
        Person found = this.personRepository.findByDni(personDto.getDni()).orElse(null);

        if(found == null) {
            savePerson(personDto);
            return;
        }

        BeanUtils.copyProperties(personDto, found);
        this.personRepository.save(found);
    }

    @Override
    public void deletePerson(Long id) {
        this.personRepository.deleteById(id);
    }

    @Override
    public PersonDto findPerson(Long id) {
        Person found = this.personRepository.findById(id).orElse(null);
        if (found == null) {
            return null;
        }

        PersonDto personDto = new PersonDto();
        BeanUtils.copyProperties(found, personDto);
        return  personDto;
    }

    @Override
    public List<PersonDto> findAll() {
        List<Person> personList = this.personRepository.findAll();

        return personList.stream().map(person -> {
            PersonDto personDto = new PersonDto();
            BeanUtils.copyProperties(person, personDto);
            return personDto;
        }).toList();
    }
}
