package ua.lviv.iot.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class RoutePK implements Serializable {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "flight_id")
    @Id
    private Integer flightId;

    public RoutePK(Integer id, Integer flightId) {
        this.id = id;
        this.flightId = flightId;
    }

    public RoutePK() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFlightId() {
        return flightId;
    }

    public void setFlightId(Integer flightId) {
        this.flightId = flightId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoutePK routePK = (RoutePK) o;
        return Objects.equals(id, routePK.id) && Objects.equals(flightId, routePK.flightId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, flightId);
    }
}
