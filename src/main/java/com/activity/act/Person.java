package com.activity.act;

import java.util.ArrayList;
import java.util.Objects;

public class Person {
    private String name;
    private String surname;
    private String id;
    //private ArrayList<Activity> votedActivities;

    /*public ArrayList<Activity> getVotedActivities() {
        return votedActivities;
    }

    public void setVotedActivities(ArrayList<Activity> votedActivities) {
        this.votedActivities = votedActivities;
    }*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    /*
    public void addVote(Activity activity){
        votedActivities.add(activity);
    }

    public void removeAllVotes(){
        votedActivities = new ArrayList<>();
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(id, person.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, id);
    }
}
