package ru.geekbrains.lesson_9_rest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "Hello Guest");
        model.addAttribute("second_message", "Welcome to our shop!");
        return "/index";
    }
    @GetMapping("/login")
    public String showMyLoginPage(){
        return "/login";
    }
}
