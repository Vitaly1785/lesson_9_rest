package ru.geekbrains.lesson_9_rest.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;
import ru.geekbrains.lesson_9_rest.dto.PersonDto;
import ru.geekbrains.lesson_9_rest.models.Person;
import ru.geekbrains.lesson_9_rest.services.person.PersonService;

import javax.validation.Valid;
import java.util.List;

@RestController
@SessionScope
@RequestMapping("/api/v1/person")
public class PersonsController {

    private final PersonService personService;

    public PersonsController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public Iterable<Person> findAll(){
        return personService.findAll();
    }

    @GetMapping("/by-ids")
    public Iterable<Person> findPersons(@RequestParam List<Long> ids){
        return personService.findAllById(ids);
    }

    @GetMapping("{id}")
    public Person findPersonById(@PathVariable Long id){
        return personService.findById(id);
    }

    @PostMapping
    public Person savePerson(@RequestBody @Valid PersonDto personDto){
        return personService.createPerson(personDto);
    }

    @PutMapping
    public Person updatePerson(@RequestBody @Valid PersonDto personDto){
        return personService.createPerson(personDto);
    }

    @DeleteMapping("{id}")
    public void deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
    }
}
