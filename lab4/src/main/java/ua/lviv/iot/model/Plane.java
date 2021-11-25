package ua.lviv.iot.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Plane {
    private Integer id;
    private String name;
    private Integer model_id;
    private Integer airline_id;
    private Integer kilometrage;
    private String aircraft_registration;

    public Plane(Integer id, String name, Integer model_id, Integer airline_id, Integer kilometrage, String aircraft_registration) {
        this.id = id;
        this.name = name;
        this.model_id = model_id;
        this.airline_id = airline_id;
        this.kilometrage = kilometrage;
        this.aircraft_registration = aircraft_registration;
    }

    public Plane(String name, Integer model_id, Integer airline_id, Integer kilometrage, String aircraft_registration) {
        this(null, name, model_id, airline_id, kilometrage, aircraft_registration);
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model_id=" + model_id +
                ", airline_id=" + airline_id +
                ", kilometrage=" + kilometrage +
                ", aircraft_registration='" + aircraft_registration + '\'' +
                '}';
    }
}
