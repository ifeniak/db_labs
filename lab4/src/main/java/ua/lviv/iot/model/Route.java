package ua.lviv.iot.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Route {
    private Integer id;
    private String name;
    private Integer length;
    private Double duration;
    private Integer danger_level;
    private Boolean is_direct;
    private Integer flight_id;

    public Route(Integer id, String name, Integer length, Double duration, Integer danger_level, Boolean is_direct, Integer flight_id) {
        this.id = id;
        this.name = name;
        this.length = length;
        this.duration = duration;
        this.danger_level = danger_level;
        this.is_direct = is_direct;
        this.flight_id = flight_id;
    }

    public Route(String name, Integer length, Double duration, Integer danger_level, Boolean is_direct, Integer flight_id) {
        this(null, name, length, duration, danger_level, is_direct, flight_id);
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", length=" + length +
                ", duration=" + duration +
                ", danger_level=" + danger_level +
                ", is_direct=" + is_direct +
                ", flight_id=" + flight_id +
                '}';
    }
}
