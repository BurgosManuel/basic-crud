package com.example.trapecioinv.controller;

import com.example.trapecioinv.domain.dto.PersonDto;
import com.example.trapecioinv.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("{id}")
    public PersonDto findPersonById(@PathVariable Long id) {
        return personService.findPerson(id);
    }

    @PostMapping
    public void savePerson(@RequestBody PersonDto personDto) {
        personService.savePerson(personDto);
    }

    @PutMapping
    public void updatePerson(@RequestBody PersonDto personDto) {
        personService.updatePerson(personDto);
    }

    @DeleteMapping("{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }
}
