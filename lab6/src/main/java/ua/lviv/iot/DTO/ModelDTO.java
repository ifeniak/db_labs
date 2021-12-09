package ua.lviv.iot.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.Link;
import ua.lviv.iot.domain.Model;
import ua.lviv.iot.exception.NoSuchModelException;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ModelDTO {
    private Integer id;
    private String name;
    private Double height;
    private Double length;
    private Double width;
    private String destination;
    private String color;

}
