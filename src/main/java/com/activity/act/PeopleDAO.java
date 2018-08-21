package com.activity.act;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class PeopleDAO {
    public ArrayList<Person> allPeople;

    public ArrayList<Person> getAllPeople() {
        return allPeople;
    }

    public void setAllPeople(ArrayList<Person> allPeople) {
        this.allPeople = allPeople;
    }

    PeopleDAO(){
        allPeople = new ArrayList<Person>();
    }

    public Person findPersonById(String id){
        for (Person person : allPeople){
            if (person.getId().equals(id)){
                return person;
            }
        }
        return null;
    }

    public void patch(Person person, String id) {
        Person oldPerson = findPersonById(person.getId());
        allPeople.remove(oldPerson);
        addPerson(person);
    }

    public Person removePerson(String id) {
        Person person = findPersonById(id);
        allPeople.remove(person);
        return person;
    }

    public Person addPerson(Person person) {
        if(person.getId() == null) {
            String id = UUID.randomUUID().toString();
            person.setId(id);
        }
        //person.setVotedActivities(new ArrayList<>());
        allPeople.add(person);
        return person;
    }
}
