package ru.geekbrains.lesson_9_rest.services.product;

import ru.geekbrains.lesson_9_rest.dto.ProductDto;
import ru.geekbrains.lesson_9_rest.models.Product;

import java.util.List;

public interface ProductService {
    Iterable<Product> findAll();

    Iterable<Product> findAllById(List<Long> ids);

    Product findById(Long id);

    Product createProduct(ProductDto productDto);

    Product updateProduct(ProductDto productDto);

    void deleteProduct(Long id);
}
