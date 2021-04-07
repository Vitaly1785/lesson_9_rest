package ru.geekbrains.lesson_9_rest.services.person;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.lesson_9_rest.dao.PersonDao;
import ru.geekbrains.lesson_9_rest.dao.RoleDao;
import ru.geekbrains.lesson_9_rest.dto.PersonDto;
import ru.geekbrains.lesson_9_rest.exceptions.PersonNotFoundException;
import ru.geekbrains.lesson_9_rest.exceptions.RoleNotFoundException;
import ru.geekbrains.lesson_9_rest.models.Person;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;
    private final RoleDao roleDao;

    public PersonServiceImpl(PersonDao personDao, RoleDao roleDao) {
        this.personDao = personDao;
        this.roleDao = roleDao;
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
        return personDao.findById(id).orElseThrow(() -> new PersonNotFoundException(String.format("Person with id %s not found", id)));
    }

    @Override
    @Transactional
    public Person createPerson(PersonDto personDto) {
        Person person = new Person();
        person.setName(personDto.getName());
        Optional<Person> optionalPerson = personDao.findByLogin(personDto.getLogin());
        if (optionalPerson.isPresent()) {
            throw new PersonNotFoundException("Person with this Login already exist");
        }
        person.setLogin(personDto.getLogin());
        person.setPassword(personDto.getPassword());
        personDao.save(person);
        return person;
    }

    @Override
    @Transactional
    public Person updatePerson(PersonDto personDto, Long id) {
        Person person = findById(id);
        person.setName(personDto.getName());
        person.setRole(roleDao.findByName(personDto.getRole()).orElseThrow(() -> new RoleNotFoundException("Role not found")));
        personDao.save(person);
        return person;
    }

    @Override
    @Transactional
    public void deletePerson(Long id) {
        personDao.delete(personDao.findById(id).orElseThrow(() -> new PersonNotFoundException(String.format("Person was not deleted. Person with id %s not found", id))));
    }
}
