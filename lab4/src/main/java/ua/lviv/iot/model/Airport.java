package ua.lviv.iot.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Airport {
    private String name;
    private String quality;
    private Integer planes_capacity;
    private String city_name;

    public Airport(String name, String quality, Integer planes_capacity, String city_name) {
        this.name = name;
        this.quality = quality;
        this.planes_capacity = planes_capacity;
        this.city_name = city_name;
    }

    public Airport(String quality, Integer planes_capacity, String city_name) {
        this(null, quality, planes_capacity, city_name);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "name='" + name + '\'' +
                ", quality='" + quality + '\'' +
                ", planes_capacity=" + planes_capacity +
                ", city_name='" + city_name + '\'' +
                '}';
    }
}
