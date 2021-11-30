package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "airport")
public class Airport {
    public Airport(String quality, Integer planesCapacity, String cityName) {
        this.quality = quality;
        this.planesCapacity = planesCapacity;
        this.cityName = cityName;
    }

    public Airport() {
    }

    @Override
    public String toString() {
        return "Airport{" +
                "name='" + name + '\'' +
                ", quality='" + quality + '\'' +
                ", planesCapacity=" + planesCapacity +
                ", cityName='" + cityName + '\'' +
                '}';
    }

    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "quality")
    private String quality;
    @Basic
    @Column(name = "planes_capacity")
    private Integer planesCapacity;
    @Basic
    @Column(name = "city_name")
    private String cityName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public Integer getPlanesCapacity() {
        return planesCapacity;
    }

    public void setPlanesCapacity(Integer planesCapacity) {
        this.planesCapacity = planesCapacity;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(name, airport.name) && Objects.equals(quality, airport.quality) && Objects.equals(planesCapacity, airport.planesCapacity) && Objects.equals(cityName, airport.cityName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, quality, planesCapacity, cityName);
    }

}
