package ru.geekbrains.lesson_9_rest.exceptions;

public class ProductNotFoundException extends NotFoundException {

    public ProductNotFoundException(String message) {
        super(message);
    }
}
