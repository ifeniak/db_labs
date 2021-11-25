package ua.lviv.iot.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Plane_flight_history {
    private Integer plane_id;
    private Integer flight_id;

    public Plane_flight_history(Integer plane_id, Integer flight_id) {
        this.plane_id = plane_id;
        this.flight_id = flight_id;
    }

    @Override
    public String toString() {
        return "plane_flight_history{" +
                "plane_id=" + plane_id +
                ", flight_id=" + flight_id +
                '}';
    }
}
