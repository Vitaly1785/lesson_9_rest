package ru.geekbrains.lesson_9_rest.dto;


import javax.validation.constraints.NotBlank;

public class PersonDto {
    @NotBlank(message = "the \"name\" field should not be empty")
    private String name;
    private String role;
    private String login;
    private String password;

    public PersonDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
