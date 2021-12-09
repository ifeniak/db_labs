package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "location")
public class Location {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;

    public Location() {
    }

    public Location(Double speed, Double latitude, Double longitude, String governmentalTerritories, String nongovernmentalTerritories, Integer planeId) {
        this.speed = speed;
        this.latitude = latitude;
        this.longitude = longitude;
        this.governmentalTerritories = governmentalTerritories;
        this.nongovernmentalTerritories = nongovernmentalTerritories;
        this.planeId = planeId;
    }

    @Basic
    @Column(name = "speed")
    private Double speed;
    @Basic
    @Column(name = "latitude")
    private Double latitude;
    @Basic
    @Column(name = "longitude")
    private Double longitude;
    @Basic
    @Column(name = "governmental_territories")
    private String governmentalTerritories;
    @Basic
    @Column(name = "nongovernmental_territories")
    private String nongovernmentalTerritories;
    @Basic
    @Column(name = "plane_id")
    private Integer planeId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getGovernmentalTerritories() {
        return governmentalTerritories;
    }

    public void setGovernmentalTerritories(String governmentalTerritories) {
        this.governmentalTerritories = governmentalTerritories;
    }

    public String getNongovernmentalTerritories() {
        return nongovernmentalTerritories;
    }

    public void setNongovernmentalTerritories(String nongovernmentalTerritories) {
        this.nongovernmentalTerritories = nongovernmentalTerritories;
    }

    public Integer getPlaneId() {
        return planeId;
    }

    public void setPlaneId(Integer planeId) {
        this.planeId = planeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(id, location.id) && Objects.equals(speed, location.speed) && Objects.equals(latitude, location.latitude) && Objects.equals(longitude, location.longitude) && Objects.equals(governmentalTerritories, location.governmentalTerritories) && Objects.equals(nongovernmentalTerritories, location.nongovernmentalTerritories) && Objects.equals(planeId, location.planeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, speed, latitude, longitude, governmentalTerritories, nongovernmentalTerritories, planeId);
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", speed=" + speed +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", governmentalTerritories='" + governmentalTerritories + '\'' +
                ", nongovernmentalTerritories='" + nongovernmentalTerritories + '\'' +
                ", planeId=" + planeId +
                '}';
    }
}
