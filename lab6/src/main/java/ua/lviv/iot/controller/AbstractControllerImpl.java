package ua.lviv.iot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.mapper.AbstractMapper;
import ua.lviv.iot.service.AbstractService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractControllerImpl<Entity, DTO, ID> implements AbstractController<Entity, DTO, ID>{
    AbstractService<Entity, ID> service = getService();
    AbstractMapper<Entity, DTO> mapper = getMapper();

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<DTO>> getAll() {
        List<Entity> objects = getService().getAll();
        List<DTO> objectsDTO = new ArrayList<>();
        for (Entity object : objects) {
            objectsDTO.add(getMapper().mapObjectToDTO(object));
        }
        return new ResponseEntity<>(objectsDTO, HttpStatus.OK);
    }

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public @ResponseBody ResponseEntity<DTO> get(@PathVariable ID id) {
        Entity object = getService().getByID(id);
        if (object != null) {
            return new ResponseEntity<>(getMapper().mapObjectToDTO(object), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody ResponseEntity<Void> create(@RequestBody Entity newObject) {
        getService().create(newObject);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}",
            consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody ResponseEntity<Entity> update(@PathVariable ID id, @RequestBody Entity entity) {
       // Entity old_entity = getService().getByID(id);
        if (getService().getByID(id) != null) {
            getService().update(id, entity);
            return new ResponseEntity<>(entity, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<DTO> delete(@PathVariable ID id) {
        if(getService().getByID(id) != null) {
            getService().delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
