package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "country")
public class Country {
    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", gdp=" + gdp +
                ", size=" + size +
                ", population=" + population +
                '}';
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "gdp")
    private Integer gdp;
    @Basic
    @Column(name = "size")
    private Double size;
    @Basic
    @Column(name = "population")
    private Integer population;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGdp() {
        return gdp;
    }

    public void setGdp(Integer gdp) {
        this.gdp = gdp;
    }

    public Country(Integer gdp, Double size, Integer population) {
        this.gdp = gdp;
        this.size = size;
        this.population = population;
    }

    public Double getSize() {
        return size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Country() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(name, country.name) && Objects.equals(gdp, country.gdp) && Objects.equals(size, country.size) && Objects.equals(population, country.population);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gdp, size, population);
    }
}
