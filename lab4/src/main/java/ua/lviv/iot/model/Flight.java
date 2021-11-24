package ua.lviv.iot.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Flight {
    private Integer id;
    private String name;
    private String airport_departure;
    private String airport_arrival;

    public Flight(Integer id, String name, String airport_departure, String airport_arrival) {
        this.id = id;
        this.name = name;
        this.airport_departure = airport_departure;
        this.airport_arrival = airport_arrival;
    }

    public Flight(String name, String airport_departure, String airport_arrival) {
        this(null, name, airport_departure, airport_arrival);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", airport_departure='" + airport_departure + '\'' +
                ", airport_arrival='" + airport_arrival + '\'' +
                '}';
    }
}
