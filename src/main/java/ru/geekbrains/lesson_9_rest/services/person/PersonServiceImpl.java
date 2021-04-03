package ru.geekbrains.lesson_9_rest.services.person;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.lesson_9_rest.dao.PersonDao;
import ru.geekbrains.lesson_9_rest.dto.PersonDto;
import ru.geekbrains.lesson_9_rest.exceptions.PersonNotFoundException;
import ru.geekbrains.lesson_9_rest.models.Person;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService{

    private final PersonDao personDao;

    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    @Transactional
    public Iterable<Person> findAll() {
        return personDao.findAll();
    }

    @Override
    @Transactional
    public Iterable<Person> findAllById(List<Long> ids) {
        return personDao.findAllById(ids);
    }

    @Override
    @Transactional
    public Person findById(Long id) {
        return personDao.findById(id).orElseThrow(()->new PersonNotFoundException(String.format("Person with id %s not found", id)));
    }

    @Override
    @Transactional
    public Person createPerson(PersonDto personDto) {
        Person person = new Person();
        person.setName(personDto.getName());
        personDao.save(person);
        return person;
    }

    @Override
    @Transactional
    public Person updatePerson(PersonDto personDto, Long id) {
        Person person = findById(id);
        person.setName(personDto.getName());
        personDao.save(person);
        return person;
    }

    @Override
    @Transactional
    public void deletePerson(Long id) {
        personDao.delete(personDao.findById(id).orElseThrow(() -> new PersonNotFoundException(String.format("Person was not deleted. Person with id %s not found", id))));
    }
}
