package ua.lviv.iot.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "model")
public class Model {
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

    public Model() {
    }

    public Model(String name, Double height, Double length, Double width, String destination, String color) {
        this.name = name;
        this.height = height;
        this.length = length;
        this.width = width;
        this.destination = destination;
        this.color = color;
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "height")
    private Double height;
    @Basic
    @Column(name = "length")
    private Double length;
    @Basic
    @Column(name = "width")
    private Double width;
    @Basic
    @Column(name = "destination")
    private String destination;
    @Basic
    @Column(name = "color")
    private String color;

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

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Model model = (Model) o;
        return Objects.equals(id, model.id) && Objects.equals(name, model.name) && Objects.equals(height, model.height) && Objects.equals(length, model.length) && Objects.equals(width, model.width) && Objects.equals(destination, model.destination) && Objects.equals(color, model.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, height, length, width, destination, color);
    }
}
