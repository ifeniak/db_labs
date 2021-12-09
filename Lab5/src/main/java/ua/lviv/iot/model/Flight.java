package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "flight")
public class Flight {
    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", airportDeparture='" + airportDeparture + '\'' +
                ", airportArrival='" + airportArrival + '\'' +
                '}';
    }

    public Flight() {
    }

    public Flight(String name, String airportDeparture, String airportArrival) {
        this.name = name;
        this.airportDeparture = airportDeparture;
        this.airportArrival = airportArrival;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "airport_departure")
    private String airportDeparture;
    @Basic
    @Column(name = "airport_arrival")
    private String airportArrival;

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

    public String getAirportDeparture() {
        return airportDeparture;
    }

    public void setAirportDeparture(String airportDeparture) {
        this.airportDeparture = airportDeparture;
    }

    public String getAirportArrival() {
        return airportArrival;
    }

    public void setAirportArrival(String airportArrival) {
        this.airportArrival = airportArrival;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(id, flight.id) && Objects.equals(name, flight.name) && Objects.equals(airportDeparture, flight.airportDeparture) && Objects.equals(airportArrival, flight.airportArrival);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, airportDeparture, airportArrival);
    }
}
