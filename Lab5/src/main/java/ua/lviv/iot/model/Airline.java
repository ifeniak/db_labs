package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "airline")
public class Airline {
    @Override
    public String toString() {
        return "Airline{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capitalization=" + capitalization +
                ", countryName='" + countryName + '\'' +
                '}';
    }

    public Airline(String name, Double capitalization, String countryName) {
        this.name = name;
        this.capitalization = capitalization;
        this.countryName = countryName;
    }

    public Airline() {
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "capitalization")
    private Double capitalization;
    @Basic
    @Column(name = "country_name")
    private String countryName;

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

    public Double getCapitalization() {
        return capitalization;
    }

    public void setCapitalization(Double capitalization) {
        this.capitalization = capitalization;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airline airline = (Airline) o;
        return Objects.equals(id, airline.id) && Objects.equals(name, airline.name) && Objects.equals(capitalization, airline.capitalization) && Objects.equals(countryName, airline.countryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, capitalization, countryName);
    }
}
