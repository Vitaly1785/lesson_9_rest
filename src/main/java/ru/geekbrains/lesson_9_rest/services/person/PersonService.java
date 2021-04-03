package ru.geekbrains.lesson_9_rest.services.person;

import ru.geekbrains.lesson_9_rest.dto.PersonDto;
import ru.geekbrains.lesson_9_rest.models.Person;

import java.util.List;

public interface PersonService {
    Iterable<Person> findAll();

    Iterable<Person> findAllById(List<Long> ids);

    Person findById(Long id);

    Person createPerson(PersonDto personDto);

    Person updatePerson(PersonDto personDto, Long id);

    void deletePerson(Long id);
}
