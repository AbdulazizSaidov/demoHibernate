package testMappingHibernate.entity.xmlmapping;

import java.util.Collection;


public class Address {
    private Long id;
    private String city;
    private String street;
    private Collection<Employee> col;

    public Address() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Collection<Employee> getCol() {
        return col;
    }

    public void setCol(Collection<Employee> col) {
        this.col = col;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", col=" + col +
                '}';
    }
}
