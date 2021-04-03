package ru.geekbrains.lesson_9_rest.exceptions;

public class PersonNotFoundException extends NotFoundException {
    public PersonNotFoundException(String message) {
        super(message);
    }
}
