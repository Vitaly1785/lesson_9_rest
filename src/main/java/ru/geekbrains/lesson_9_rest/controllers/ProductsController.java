package ru.geekbrains.lesson_9_rest.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;
import ru.geekbrains.lesson_9_rest.dto.ProductDto;
import ru.geekbrains.lesson_9_rest.models.Product;
import ru.geekbrains.lesson_9_rest.services.ProductService;

import java.util.List;


@RestController
@SessionScope
@RequestMapping("/api/v1/product")
public class ProductsController {
    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Iterable<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("by-ids")
    public Iterable<Product> findProducts(@RequestParam List<Long> ids) {
        return productService.findAllById(ids);
    }

    @GetMapping("{id}")
    public Product findProduct(@PathVariable Long id) {
        return productService.findById(id);
    }

    @PostMapping
    public Product saveProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @PutMapping
    public Product updateProduct(@RequestBody ProductDto productDto) {
        return productService.updateProduct(productDto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
}
