package ru.geekbrains.lesson_9_rest.services.basket;

import org.springframework.stereotype.Service;
import ru.geekbrains.lesson_9_rest.dto.BasketDto;
import ru.geekbrains.lesson_9_rest.models.Basket;
import ru.geekbrains.lesson_9_rest.models.Product;
import ru.geekbrains.lesson_9_rest.services.person.PersonService;
import ru.geekbrains.lesson_9_rest.services.product.ProductService;

import java.util.List;
import java.util.Map;

@Service
public class BasketServiceImpl implements BasketService {
    private final Basket basket;
    private final Map<Long, List<Product>> orderBasket;
    private final ProductService productService;
    private final PersonService personService;

    public BasketServiceImpl(Basket basket, ProductService productService, PersonService personService) {
        this.basket = basket;
        orderBasket = basket.getBasket();
        this.productService = productService;
        this.personService = personService;
    }

    @Override
    public Map<Long, List<Product>> addProducts(BasketDto basketDto) {
        List<Product> products = (List<Product>) productService.findAllById(basketDto.getProductsIds());
        orderBasket.put(personService.findById(basketDto.getId()).getId(), products);
        return orderBasket;
    }

    @Override
    public void deleteProducts(Long id) {
        orderBasket.remove(id);
    }

    @Override
    public Iterable<Product> showBasket(Long id) {
        return orderBasket.get(id);
    }

    @Override
    public Map<Long, List<Product>> showAll() {
        return orderBasket;
    }
}
