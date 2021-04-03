package ru.geekbrains.lesson_9_rest.controllers;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;
import ru.geekbrains.lesson_9_rest.dto.BasketDto;
import ru.geekbrains.lesson_9_rest.models.Product;
import ru.geekbrains.lesson_9_rest.services.basket.BasketService;

import java.util.List;
import java.util.Map;

@RestController
@SessionScope
@RequestMapping("/api/v1/basket")
public class BasketsController {
    private final BasketService basketService;

    public BasketsController(BasketService basketService) {
        this.basketService = basketService;
    }

    @GetMapping
    @ApiOperation("Show all orders with all ids")
    public Map<Long, List<Product>> showAll(){
        return basketService.showAll();
    }

    @GetMapping("{id}")
    @ApiOperation("Show orders by id person")
    public Iterable<Product> showBasket(@PathVariable Long id){
        return basketService.showBasket(id);
    }

    @PostMapping
    @ApiOperation("Add order to basket")
    public Map<Long, List<Product>> addProducts(@RequestBody BasketDto basketDto){
        return basketService.addProducts(basketDto);
    }

    @DeleteMapping("{id}")
    @ApiOperation("Delete basket by id")
    public void deleteOrderProducts(@PathVariable Long id){
       basketService.deleteProducts(id);
    }
}
