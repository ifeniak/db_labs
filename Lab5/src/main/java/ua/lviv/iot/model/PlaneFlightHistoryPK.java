package ua.lviv.iot.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class PlaneFlightHistoryPK implements Serializable {
    @Column(name = "plane_id")
    @Id
    private Integer planeId;
    @Column(name = "flight_id")
    @Id
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

    public PlaneFlightHistoryPK(Integer planeId, Integer flightId) {
        this.planeId = planeId;
        this.flightId = flightId;
    }

    public PlaneFlightHistoryPK() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlaneFlightHistoryPK that = (PlaneFlightHistoryPK) o;
        return Objects.equals(planeId, that.planeId) && Objects.equals(flightId, that.flightId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planeId, flightId);
    }
}
