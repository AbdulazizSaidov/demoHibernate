package testMappingHibernate.service;

import testMappingHibernate.entity.annatationmapping.Person;
import testMappingHibernate.service.annatationmappingservice.AnnaMapServ;
import testMappingHibernate.service.xmlmappingservice.XmlMapServ;


public class TestEntity {



    public static void main(String[] args) {
        System.out.println("Person's First_Name = " + AnnaMapServ.getPersonById(AnnaMapServ.savePerson()).getFirstName());
        System.out.println("Employee's Last_Name = "+XmlMapServ.saveEmployee().getLastName());
     }





}
