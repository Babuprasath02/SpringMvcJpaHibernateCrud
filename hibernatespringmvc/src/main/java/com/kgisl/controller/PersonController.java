package com.kgisl.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kgisl.model.Person;
import com.kgisl.service.PersonService;
@Controller
public class PersonController {
    private PersonService personService;
    @Autowired(required=true)
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
    @RequestMapping(value="/person",method = RequestMethod.GET)
    private String listPersons(Model model){
        model.addAttribute("person", new Person());
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
        
    }
    @RequestMapping(value="/person/add",method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person p){
        if(p.getId()==0){
            this.personService.addPerson(p);
        }else{
            this.personService.updatePerson(p);
        }
        return "redirect:/person";
    }
    @RequestMapping(value="/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
        this.personService.removePerson(id);
        return "redirect:/person";
    }
    @RequestMapping(value="/edit/{id}")
    public String editPerson(@PathVariable("id") int id,Model model){
        model.addAttribute("person", this.personService.getPersonById(id));
        model.addAttribute("listPersons", this.personService.listPersons());
        return "person";
    }
    
}
