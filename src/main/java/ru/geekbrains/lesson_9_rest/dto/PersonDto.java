package ru.geekbrains.lesson_9_rest.dto;

import javax.validation.constraints.NotBlank;

public class PersonDto {
    @NotBlank(message = "the \"name\" field should not be empty")
    private String name;

    public PersonDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
