package ua.lviv.iot.controller;

import org.springframework.http.ResponseEntity;
import ua.lviv.iot.mapper.AbstractMapper;
import ua.lviv.iot.service.AbstractService;

import java.util.List;

public interface AbstractController<Entity, DTO, ID> {
    AbstractService<Entity, ID> getService();
    AbstractMapper<Entity, DTO> getMapper();

    ResponseEntity<List<DTO>> getAll();
    ResponseEntity<DTO> get(ID id);
    ResponseEntity<Entity> update(ID id, Entity entity);
    ResponseEntity<DTO> delete(ID id);
    ResponseEntity<Void> create(Entity entity);
}
