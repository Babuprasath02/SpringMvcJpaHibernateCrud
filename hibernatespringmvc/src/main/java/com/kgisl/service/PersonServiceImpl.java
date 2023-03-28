package com.kgisl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kgisl.dao.PersonDao;
import com.kgisl.model.Person;
@Service
public class PersonServiceImpl implements PersonService{
    private PersonDao personDao;
    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public void addPerson(Person p) {
        this.personDao.addPerson(p);
    }

    @Override
    public void updatePerson(Person p) {
        this.personDao.updatePerson(p);
    }

    @Override
    public List<Person> listPersons() {
        return this.personDao.getPersons();
    }

    @Override
    public Person getPersonById(int id) {
        return this.personDao.getPersonById(id);
    }

    @Override
    public void removePerson(int id) {
        this.personDao.removePerson(id);
    }
    
}
