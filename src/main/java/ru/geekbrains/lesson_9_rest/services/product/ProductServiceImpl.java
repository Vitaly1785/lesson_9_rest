package ru.geekbrains.lesson_9_rest.services.product;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.geekbrains.lesson_9_rest.dao.ProductDao;
import ru.geekbrains.lesson_9_rest.dto.ProductDto;
import ru.geekbrains.lesson_9_rest.exceptions.ProductNotFoundException;
import ru.geekbrains.lesson_9_rest.models.Product;

import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;


    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    @Transactional
    public Iterable<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    @Transactional
    public Iterable<Product> findAllById(List<Long> ids) {
        return productDao.findAllById(ids);
    }

    @Override
    @Transactional
    public Product findById(Long id) {
        return productDao.findById(id).orElseThrow(() -> new ProductNotFoundException(String.format("Product with id %s not found", id)));
    }

    @Override
    @Transactional
    public Product createProduct(ProductDto productDto) {
        Product createdProduct = new Product();
        Optional<Product> product = productDao.findProductByTitle(productDto.getTitle());
        if (product.isPresent()) {
            return updateProduct(productDto);
        } else {
            createdProduct.setTitle(productDto.getTitle());
            createdProduct.setPrice(productDto.getPrice());
            productDao.save(createdProduct);
            return createdProduct;
        }
    }

    @Override
    @Transactional
    public Product updateProduct(ProductDto productDto) {
        Product product = productDao.findProductByTitle(productDto.getTitle()).orElseThrow(() -> new ProductNotFoundException(String.format("Product with title %s not found", productDto.getTitle())));
        product.setPrice(productDto.getPrice());
        productDao.save(product);
        return product;
    }

    @Override
    @Transactional
    public void deleteProduct(Long id) {
        productDao.delete(productDao.findById(id).orElseThrow(() -> new ProductNotFoundException(String.format("Product was not deleted. Product with id %s not found", id))));
    }
}
