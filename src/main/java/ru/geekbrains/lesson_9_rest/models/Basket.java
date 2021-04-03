package ru.geekbrains.lesson_9_rest.models;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Basket {
    private static Map<Long, List<Product>> basket;

    private Basket() {
    }
    public Map<Long, List<Product>> getBasket(){
        if (basket == null){
            basket = new HashMap<>();
        } else {
            throw new RuntimeException("Exception");
        }
        return basket;
    }
}
