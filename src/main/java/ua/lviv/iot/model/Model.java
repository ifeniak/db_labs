package ua.lviv.iot.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Model {

    private Integer id;
    private String name;
    private Double height;
    private Double length;
    private Double width;
    private String destination;
    private String color;

    public Model(Integer id, String name, Double height, Double length, Double width, String destination, String color) {
        this.id = id;
        this.name = name;
        this.height = height;
        this.length = length;
        this.width = width;
        this.destination = destination;
        this.color = color;
    }

    public Model(String name, Double height, Double length, Double width, String destination, String color) {
        this(null, name, height, length, width, destination, color);
    }

    @Override
    public String toString() {
        return "Model{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", height=" + height +
                ", length=" + length +
                ", width=" + width +
                ", destination='" + destination + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
