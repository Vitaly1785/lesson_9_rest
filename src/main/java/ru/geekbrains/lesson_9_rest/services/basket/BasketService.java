package ru.geekbrains.lesson_9_rest.services.basket;

import ru.geekbrains.lesson_9_rest.dto.BasketDto;
import ru.geekbrains.lesson_9_rest.models.Product;

import java.util.List;
import java.util.Map;

public interface BasketService {
    Map<Long, List<Product>> addProducts(BasketDto basketDto);
    void deleteProducts(Long id);
    Iterable<Product> showBasket(Long id);
    Map<Long, List<Product>> showAll();
}
