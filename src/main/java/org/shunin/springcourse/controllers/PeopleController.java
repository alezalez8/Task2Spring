package org.shunin.springcourse.controllers;

import org.shunin.springcourse.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.shunin.springcourse.models.Person;

import javax.validation.Valid;

/**
 * @author Neil Alishev
 */
@Controller
@RequestMapping("/people")
public class PeopleController {

   // private final PersonValidator personValidator;
    private final PersonService personService;

    @Autowired
    public PeopleController( PersonService personService) {
       // this.personValidator = personValidator;
        this.personService = personService;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people", personService.index());
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
      //  model.addAttribute("person", personDAO.show(id));
       // model.addAttribute("books", personDAO.getBooksByPersonId(id));
        model.addAttribute("person", personService.findById(id));
        return "people/show";
    }


    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") @Valid Person person,
                         BindingResult bindingResult) {
       // personValidator.validate(person, bindingResult);

        if (bindingResult.hasErrors())
            return "people/new";
//===============================
        personService.save(person);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        //===============================
        model.addAttribute("person", personService.findById(id));

        return "people/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        if (bindingResult.hasErrors())
            return "people/edit";
//===============================
       // personDAO.update(id, person);
        personService.save(person);
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        //===============================
       // personDAO.delete(id);
        personService.delete(id);
        return "redirect:/people";
    }
}
