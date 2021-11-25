package ua.lviv.iot.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Country {
    private String name;
    private Integer gdp;
    private Double size;
    private Integer population;

    public Country(String name, Integer gdp, Double size, Integer population) {
        this.name = name;
        this.gdp = gdp;
        this.size = size;
        this.population = population;
    }

    public Country(Integer gdp, Double size, Integer population) {
        this(null, gdp, size, population);
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", gdp=" + gdp +
                ", size=" + size +
                ", population='" + population + '\'' +
                '}';
    }
}
