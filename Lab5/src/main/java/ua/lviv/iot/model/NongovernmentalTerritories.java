package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "nongovernmental_territories", schema = "planes")
public class NongovernmentalTerritories {
    @Override
    public String toString() {
        return "NongovernmentalTerritories{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", dangerLevel='" + dangerLevel + '\'' +
                '}';
    }

    public NongovernmentalTerritories() {
    }

    public NongovernmentalTerritories(String type, String dangerLevel) {
        this.type = type;
        this.dangerLevel = dangerLevel;
    }

    @Id
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "type")
    private String type;
    @Basic
    @Column(name = "danger_level")
    private String dangerLevel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDangerLevel() {
        return dangerLevel;
    }

    public void setDangerLevel(String dangerLevel) {
        this.dangerLevel = dangerLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NongovernmentalTerritories that = (NongovernmentalTerritories) o;
        return Objects.equals(name, that.name) && Objects.equals(type, that.type) && Objects.equals(dangerLevel, that.dangerLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type, dangerLevel);
    }
}
