package testMappingHibernate.service.xmlmappingservice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import testMappingHibernate.entity.xmlmapping.Address;
import testMappingHibernate.entity.xmlmapping.Employee;

public class XmlMapServ {

    private static SessionFactory sessionFactory;

    static {
        init();
    }

    public static void init(){
        if (sessionFactory==null){
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        }
    }

    public static void saveEmployee(){
        Employee employee = new Employee();
        Address address = new Address();

        address.setCity("NEW_YORK");
        address.setStreet("JONES");

        employee.setName("Bob");
        employee.setLastName("CRUZ");
        employee.setAddress(address);

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(employee);
        session.save(address);
        session.getTransaction().commit();
        session.close();

    }
}
