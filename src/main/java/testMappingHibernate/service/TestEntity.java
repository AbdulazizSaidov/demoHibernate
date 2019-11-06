package testMappingHibernate.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import testMappingHibernate.entity.Person;

import java.util.List;

public class TestEntity {

    private SessionFactory sessionFactory;


     public void testCreate() throws Exception {

        Person person  = new Person();
            person.setFirstName("Jon");
            person.setAge(25);
            final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

            try {
                sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            } catch (Exception e) {
                StandardServiceRegistryBuilder.destroy(registry);
                throw e;
            }

            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(person);
            session.getTransaction().commit();
            session.close();
     }

    public static void main(String[] args) {
         TestEntity testEntity;
         try {
           testEntity = new TestEntity();
           testEntity.testCreate();
           testEntity.personList().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Person> personList(){
         Session session = sessionFactory.openSession();
         session.beginTransaction();
        return  session.createQuery("from Person").list();
    }



}
