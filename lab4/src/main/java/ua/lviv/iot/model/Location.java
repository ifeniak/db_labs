package ua.lviv.iot.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Location {
    private Integer id;
    private Double speed;
    private Double latitude;
    private Double longitude;
    private String governmental_territories;
    private String nongovernmental_territories;
    private Integer plane_id;

    public Location(Integer id, Double speed, Double latitude, Double longitude, String governmental_territories, String nongovernmental_territories, Integer plane_id) {
        this.id = id;
        this.speed = speed;
        this.latitude = latitude;
        this.longitude = longitude;
        this.governmental_territories = governmental_territories;
        this.nongovernmental_territories = nongovernmental_territories;
        this.plane_id = plane_id;
    }

    public Location(Double speed, Double latitude, Double longitude, String governmental_territories, String nongovernmental_territories, Integer plane_id) {
        this(null, speed, latitude, longitude, governmental_territories, nongovernmental_territories, plane_id);
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", speed=" + speed +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", governmental_territories='" + governmental_territories + '\'' +
                ", nongovernmental_territories='" + nongovernmental_territories + '\'' +
                ", plane_id=" + plane_id +
                '}';
    }
}
