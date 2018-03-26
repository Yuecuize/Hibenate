package demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
    @Column(name = "country")
    private String country;
    @Column(name = "city")
    private String city;

    public Address(){}

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address(String country, String city) {

        this.country = country;
        this.city = city;
    }
}
