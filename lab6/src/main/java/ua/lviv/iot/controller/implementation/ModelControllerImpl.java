package ua.lviv.iot.controller.implementation;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.lviv.iot.DTO.ModelDTO;
import ua.lviv.iot.controller.AbstractControllerImpl;
import ua.lviv.iot.domain.Model;
import ua.lviv.iot.mapper.AbstractMapper;
import ua.lviv.iot.mapper.implementation.ModelMapper;
import ua.lviv.iot.service.AbstractService;
import ua.lviv.iot.service.implementation.ModelService;

@RequestMapping(value = "/models")
@RestController
@AllArgsConstructor
public class ModelControllerImpl extends AbstractControllerImpl<Model, ModelDTO, Integer> {
    private final ModelService modelService;
    private final ModelMapper modelMapper;

    @Override
    public AbstractService<Model, Integer> getService() {
        return modelService;
    }

    @Override
    public AbstractMapper<Model, ModelDTO> getMapper() {
        return modelMapper;
    }
}
