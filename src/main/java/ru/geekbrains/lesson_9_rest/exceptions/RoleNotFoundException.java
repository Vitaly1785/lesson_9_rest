package ru.geekbrains.lesson_9_rest.exceptions;

public class RoleNotFoundException extends NotFoundException{
    public RoleNotFoundException(String message) {
        super(message);
    }
}
