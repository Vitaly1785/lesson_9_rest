package ru.geekbrains.lesson_9_rest.dao;

import org.springframework.data.repository.CrudRepository;
import ru.geekbrains.lesson_9_rest.models.Role;

import java.util.Optional;
import java.util.UUID;

public interface RoleDao extends CrudRepository<Role, UUID> {
    Optional<Role> findByName(String name);
}
