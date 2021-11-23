package ua.lviv.iot.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class City {
    private String name;
    private Integer population;
    private String status;
    private String country_name;

    public City(String name, Integer population, String status, String country_name) {
        this.name = name;
        this.population = population;
        this.status = status;
        this.country_name = country_name;
    }

    public City(Integer population, String status, String country_name) {
        this(null, population, status, country_name);
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", status='" + status + '\'' +
                ", country_name='" + country_name + '\'' +
                '}';
    }
}
