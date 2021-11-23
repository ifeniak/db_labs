package ua.lviv.iot.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Airline {
    private Integer id;
    private String name;
    private Double capitalization;
    private String country_name;

    public Airline(Integer id, String name, Double capitalization, String country_name) {
        this.id = id;
        this.name = name;
        this.capitalization = capitalization;
        this.country_name = country_name;
    }

    public Airline(String name, Double capitalization, String country_name) {
        this(null, name, capitalization, country_name);
    }

    @Override
    public String toString() {
        return "Airline{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", capitalization=" + capitalization +
                ", country_name='" + country_name + '\'' +
                '}';
    }
}
