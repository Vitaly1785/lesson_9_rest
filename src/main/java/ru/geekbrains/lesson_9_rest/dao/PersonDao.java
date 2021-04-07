package ru.geekbrains.lesson_9_rest.dao;

import org.springframework.data.repository.CrudRepository;
import ru.geekbrains.lesson_9_rest.models.Person;

import java.util.Optional;


public interface PersonDao extends CrudRepository<Person, Long> {
    Optional<Person> findByLogin(String login);
}
