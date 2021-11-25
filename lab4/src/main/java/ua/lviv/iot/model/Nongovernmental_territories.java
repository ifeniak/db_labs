package ua.lviv.iot.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Nongovernmental_territories {
    private String name;
    private String type;
    private String danger_level;

    public Nongovernmental_territories(String name, String type, String danger_level) {
        this.name = name;
        this.type = type;
        this.danger_level = danger_level;
    }

    public Nongovernmental_territories(String type, String danger_level) {
        this(null, type, danger_level);
    }

    @Override
    public String toString() {
        return "Nongovernmental_territories{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", danger_level='" + danger_level + '\'' +
                '}';
    }
}
