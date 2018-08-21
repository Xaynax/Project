package com.activity.act;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class PeopleController {

    private PeopleDAO peopleDAO;

    @Autowired
    public PeopleController(PeopleDAO peopleDAO) {
        this.peopleDAO = peopleDAO;
    }

    @GetMapping("/")
    public String get(){
        return "Hello, you're in !";
        //return null;
    }

    @GetMapping("/People")
    public List<Person> getPeople(){
        return peopleDAO.getAllPeople();
    }

    @GetMapping("/People/{id}")
    public Person getPersonById(@PathVariable String id){
        Person person = peopleDAO.findPersonById(id);
        return person;
    }

    @PostMapping("/People")
    public Person addPerson(@RequestBody Person person) {
        return peopleDAO.addPerson(person);
    }

    @PatchMapping("/People/{id}")
    public void changePerson(@RequestBody Person person, @PathVariable String id){
        peopleDAO.patch(person, id);
    }

    @DeleteMapping("People/{id}")
    public void remPerson(@PathVariable String id){
        peopleDAO.removePerson(id);
    }

    @PutMapping("People/{id}")
    public String changePerson(@PathVariable String id, @RequestBody Person person){
        if(getPersonById(id) != null && person.getId() == id){
            remPerson(id);
            addPerson(person);
            return "Person replaced successfully";
        }
        else{
            return "This ID does not exist in the DataBase";
        }
    }
}
