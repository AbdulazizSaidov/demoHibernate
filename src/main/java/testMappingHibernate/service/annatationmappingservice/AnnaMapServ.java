package testMappingHibernate.service.annatationmappingservice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import testMappingHibernate.entity.annatationmapping.Person;

import java.util.List;

public class AnnaMapServ {
    private static SessionFactory sessionFactory;
    private final static StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

  static {
      if (sessionFactory==null){
          try {
              sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
          }catch (Exception e){
              e.printStackTrace();
              StandardServiceRegistryBuilder.destroy(registry);
          }
      }
  }

    public static List<Person> persons(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        return  session.createQuery("from Person").list();
    }


    public static Person getPersonById(Long id){

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Person where id=:id", Person.class);
        query.setParameter("id", id);
        return (Person) query.getSingleResult();
    }

    public static Long savePerson() {
        Person person  = new Person();
        person.setFirstName("Jon");
        person.setAge(25);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();
        return person.getId();
    }


}
