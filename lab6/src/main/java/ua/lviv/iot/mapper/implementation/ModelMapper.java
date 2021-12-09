package ua.lviv.iot.mapper.implementation;

import org.springframework.stereotype.Component;
import ua.lviv.iot.DTO.ModelDTO;
import ua.lviv.iot.domain.Model;
import ua.lviv.iot.mapper.AbstractMapper;

@Component
public class ModelMapper implements AbstractMapper<Model, ModelDTO> {
    @Override
    public ModelDTO mapObjectToDTO(Model model) {
        if (model == null) {
            return null;
        }
        ModelDTO.ModelDTOBuilder modelDTOBuilder = ModelDTO.builder();
        modelDTOBuilder.id(model.getId());
        modelDTOBuilder.name(model.getName());
        modelDTOBuilder.length(model.getLength());
        modelDTOBuilder.destination(model.getDestination());
        modelDTOBuilder.color(model.getColor());
        modelDTOBuilder.height(model.getHeight());
        modelDTOBuilder.width(model.getWidth());
        return modelDTOBuilder.build();
    }

}
