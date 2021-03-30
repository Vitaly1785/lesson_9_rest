package ru.geekbrains.lesson_9_rest.dao;

import org.springframework.data.repository.CrudRepository;
import ru.geekbrains.lesson_9_rest.models.Product;

import java.util.Optional;

public interface ProductDao extends CrudRepository<Product, Long> {
    Optional<Product> findProductByTitle(String title);
}
