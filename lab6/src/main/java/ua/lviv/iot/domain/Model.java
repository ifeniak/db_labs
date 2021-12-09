package ua.lviv.iot.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "model")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Model {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Model model = (Model) o;

        if (!id.equals(model.id)) return false;
        if (!name.equals(model.name)) return false;
        if (height != null ? !height.equals(model.height) : model.height != null) return false;
        if (length != null ? !length.equals(model.length) : model.length != null) return false;
        if (width != null ? !width.equals(model.width) : model.width != null) return false;
        if (destination != null ? !destination.equals(model.destination) : model.destination != null) return false;
        return color != null ? color.equals(model.color) : model.color == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (length != null ? length.hashCode() : 0);
        result = 31 * result + (width != null ? width.hashCode() : 0);
        result = 31 * result + (destination != null ? destination.hashCode() : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }
}