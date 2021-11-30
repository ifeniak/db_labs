package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "route")
@IdClass(RoutePK.class)
public class Route {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;

    public Route() {
    }

    public Route(String name, Integer length, Double duration, Integer dangerLevel, Byte isDirect, Integer flightId) {
        this.name = name;
        this.length = length;
        this.duration = duration;
        this.dangerLevel = dangerLevel;
        this.isDirect = isDirect;
        this.flightId = flightId;
    }

    @Basic
    @Column(name = "length")
    private Integer length;
    @Basic
    @Column(name = "duration")
    private Double duration;
    @Basic
    @Column(name = "danger_level")
    private Integer dangerLevel;
    @Basic
    @Column(name = "is_direct")
    private Byte isDirect;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "flight_id")
    private Integer flightId;

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

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Integer getDangerLevel() {
        return dangerLevel;
    }

    public void setDangerLevel(Integer dangerLevel) {
        this.dangerLevel = dangerLevel;
    }

    public Byte getIsDirect() {
        return isDirect;
    }

    public void setIsDirect(Byte isDirect) {
        this.isDirect = isDirect;
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
        Route route = (Route) o;
        return Objects.equals(id, route.id) && Objects.equals(name, route.name) && Objects.equals(length, route.length) && Objects.equals(duration, route.duration) && Objects.equals(dangerLevel, route.dangerLevel) && Objects.equals(isDirect, route.isDirect) && Objects.equals(flightId, route.flightId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, length, duration, dangerLevel, isDirect, flightId);
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", length=" + length +
                ", duration=" + duration +
                ", dangerLevel=" + dangerLevel +
                ", isDirect=" + isDirect +
                ", flightId=" + flightId +
                '}';
    }
}
