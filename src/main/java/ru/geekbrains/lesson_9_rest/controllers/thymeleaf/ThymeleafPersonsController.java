package ru.geekbrains.lesson_9_rest.controllers.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.lesson_9_rest.dto.PersonDto;
import ru.geekbrains.lesson_9_rest.models.Person;
import ru.geekbrains.lesson_9_rest.services.person.PersonService;

@Controller
@RequestMapping("/persons")
public class ThymeleafPersonsController {
    private final PersonService personService;

    public ThymeleafPersonsController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public String showAll(Model model) {
        model.addAttribute("persons", personService.findAll());
        return "/persons/showPersons";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
        model.addAttribute("person", personService.findById(id));
        return "/persons/idPerson";
    }

    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());
        return "/persons/newPerson";
    }

    @PostMapping
    public String addPerson(@ModelAttribute("person") PersonDto personDto) {
        personService.createPerson(personDto);
        return "redirect:/persons";
    }

    @GetMapping("/{id}/edit")
    public String editPerson(@PathVariable Long id, Model model) {
        model.addAttribute("person", personService.findById(id));
        return "/persons/editPerson";
    }

    @PatchMapping("/{id}")
    public String updatePerson(@ModelAttribute("person") PersonDto personDto, @PathVariable Long id) {
        personService.updatePerson(personDto, id);
        return "redirect:/persons";
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return "redirect:/persons";
    }
}
