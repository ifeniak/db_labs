package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "plane_flight_history", schema = "planes")
@IdClass(PlaneFlightHistoryPK.class)
public class PlaneFlightHistory {
    @Override
    public String toString() {
        return "PlaneFlightHistory{" +
                "planeId=" + planeId +
                ", flightId=" + flightId +
                '}';
    }

    public PlaneFlightHistory() {
    }

    public PlaneFlightHistory(Integer planeId, Integer flightId) {
        this.planeId = planeId;
        this.flightId = flightId;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "plane_id")
    private Integer planeId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "flight_id")
    private Integer flightId;

    public Integer getPlaneId() {
        return planeId;
    }

    public void setPlaneId(Integer planeId) {
        this.planeId = planeId;
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
        PlaneFlightHistory that = (PlaneFlightHistory) o;
        return Objects.equals(planeId, that.planeId) && Objects.equals(flightId, that.flightId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planeId, flightId);
    }
}
