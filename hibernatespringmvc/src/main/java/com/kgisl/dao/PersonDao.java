package com.kgisl.dao;

import java.util.List;

import com.kgisl.model.Person;

public interface PersonDao {
    public void addPerson(Person p);
    public void updatePerson(Person p);
    public List<Person> getPersons();
    public Person getPersonById(int id);
    public void removePerson(int id);      
    
}
