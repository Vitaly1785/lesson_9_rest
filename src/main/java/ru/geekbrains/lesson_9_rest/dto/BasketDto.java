package ru.geekbrains.lesson_9_rest.dto;

import java.util.List;
public class BasketDto {
    private Long id;
    private List<Long> productsIds;

    public BasketDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getProductsIds() {
        return productsIds;
    }

    public void setProductsIds(List<Long> productsIds) {
        this.productsIds = productsIds;
    }
}
