package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "city")
public class City {
    public City(Integer population, String status, String countryName) {
        this.population = population;
        this.status = status;
        this.countryName = countryName;
    }

    public City() {
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", status='" + status + '\'' +
                ", countryName='" + countryName + '\'' +
                '}';
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "population")
    private Integer population;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "country_name")
    private String countryName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        City city = (City) o;
        return Objects.equals(name, city.name) && Objects.equals(population, city.population) && Objects.equals(status, city.status) && Objects.equals(countryName, city.countryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, population, status, countryName);
    }
}
