package com.kgisl.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.kgisl.model.Person;
@Repository
public class PersonDaoImpl implements PersonDao{
    private static final Logger logger = LoggerFactory.getLogger(PersonDaoImpl.class);
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addPerson(Person p) {
        Session s = this.sessionFactory.getCurrentSession();
        s.persist(p);
        logger.info("Person Details are Saved Successfully, Person Details= "+p);
       
    }

    @Override
    public void updatePerson(Person p) {
        Session s=this.sessionFactory.getCurrentSession();
        s.update(p);
        logger.info("Person Details are Updated Successfully, Person Details= "+p);
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Person> getPersons() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> personList =session.createQuery("from Person").list();
        for(Person p : personList){
            logger.info("Person List "+p);
        }

        return personList;
      
    }

    @Override
    public Person getPersonById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Person p = session.load(Person.class, new Integer(id));
        logger.info("Person Loaded Successfully= "+p);
         return p;
    }

    @Override
    public void removePerson(int id) {
        Session session = this.sessionFactory.getCurrentSession();
       Person p = session.load(Person.class, new Integer(id));
       if(p!=null){
        session.delete(p);
       }
       logger.info("Person Deleted Successfully, Person Details "+p);
    }

   
    
}
