package ua.lviv.iot.mapper;

public interface AbstractMapper<Entity, DTO> {
    public abstract DTO mapObjectToDTO(Entity entity);
}
