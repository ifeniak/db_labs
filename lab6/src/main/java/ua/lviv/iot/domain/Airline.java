package ua.lviv.iot.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Airline {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "capitalization")
    private String capitalization;
    @ManyToOne
    @JoinColumn(name = "country_name", referencedColumnName = "name", nullable = false)
    private Country countryByCountryName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapitalization() {
        return capitalization;
    }

    public void setCapitalization(String capitalization) {
        this.capitalization = capitalization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airline airline = (Airline) o;
        return Objects.equals(id, airline.id) && Objects.equals(name, airline.name) && Objects.equals(capitalization, airline.capitalization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, capitalization);
    }

    public Country getCountryByCountryName() {
        return countryByCountryName;
    }

    public void setCountryByCountryName(Country countryByCountryName) {
        this.countryByCountryName = countryByCountryName;
    }
}
