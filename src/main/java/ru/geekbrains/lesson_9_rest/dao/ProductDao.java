package ru.geekbrains.lesson_9_rest.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import ru.geekbrains.lesson_9_rest.models.Product;

import java.util.Optional;

public interface ProductDao extends CrudRepository<Product, Long> {
    Optional<Product> findProductByTitle(String title);
    Page<Product> findAllByOrderByPriceAsc(Pageable pageable);
    Page<Product>findAllByOrderByPriceDesc(Pageable pageable);
    Page<Product> findAll(Pageable pageable);
}
