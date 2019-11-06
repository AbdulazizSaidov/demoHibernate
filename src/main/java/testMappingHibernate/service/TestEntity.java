package testMappingHibernate.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import testMappingHibernate.entity.annatationmapping.Person;
import testMappingHibernate.service.annatationmappingservice.AnnaMapServ;
import testMappingHibernate.service.xmlmappingservice.XmlMapServ;

import java.util.List;


public class TestEntity {


/*
     public static void testCreate() throws Exception {

        Person person  = new Person();
            person.setFirstName("Jon");
            person.setAge(25);
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(person);
            session.getTransaction().commit();
            session.close();
     }*/


    public static void main(String[] args) {
      Person person = AnnaMapServ.getPersonById((long) 15);
        System.out.println("PERSON ID = "+person.getAge());

        XmlMapServ.saveEmployee();

    }





}
