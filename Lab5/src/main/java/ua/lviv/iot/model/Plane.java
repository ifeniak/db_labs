package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "plane")
public class Plane {
    public Plane() {
    }

    public Plane(String name, Integer modelId, Integer airlineId, Integer kilometrage, String aircraftRegistration) {
        this.name = name;
        this.modelId = modelId;
        this.airlineId = airlineId;
        this.kilometrage = kilometrage;
        this.aircraftRegistration = aircraftRegistration;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", modelId=" + modelId +
                ", airlineId=" + airlineId +
                ", kilometrage=" + kilometrage +
                ", aircraftRegistration='" + aircraftRegistration + '\'' +
                '}';
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "model_id")
    private Integer modelId;
    @Basic
    @Column(name = "airline_id")
    private Integer airlineId;
    @Basic
    @Column(name = "kilometrage")
    private Integer kilometrage;
    @Basic
    @Column(name = "aircraft_registration")
    private String aircraftRegistration;

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

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public Integer getAirlineId() {
        return airlineId;
    }

    public void setAirlineId(Integer airlineId) {
        this.airlineId = airlineId;
    }

    public Integer getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(Integer kilometrage) {
        this.kilometrage = kilometrage;
    }

    public String getAircraftRegistration() {
        return aircraftRegistration;
    }

    public void setAircraftRegistration(String aircraftRegistration) {
        this.aircraftRegistration = aircraftRegistration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plane plane = (Plane) o;
        return Objects.equals(id, plane.id) && Objects.equals(name, plane.name) && Objects.equals(modelId, plane.modelId) && Objects.equals(airlineId, plane.airlineId) && Objects.equals(kilometrage, plane.kilometrage) && Objects.equals(aircraftRegistration, plane.aircraftRegistration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, modelId, airlineId, kilometrage, aircraftRegistration);
    }
}
