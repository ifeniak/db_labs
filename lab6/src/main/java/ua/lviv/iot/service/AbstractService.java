package ua.lviv.iot.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class AbstractService<Entity, ID> {
    protected abstract JpaRepository<Entity, ID> getRepository();

    public List<Entity> getAll() {
        return getRepository().findAll();
    }

    public Entity getByID(ID id) {
        return getRepository().findById(id)
                .orElse(null);
    }

    public Entity create(Entity entity) {
        return getRepository().save(entity);
    }

    public Entity update(ID id, Entity entity) {
        if (getRepository().findById(id).isPresent()) {
            return getRepository().save(entity);
        }
        return null;
    }

    public Entity delete(ID id) {
        Entity entity = getRepository().getById(id);
        if (entity != null) {
            getRepository().deleteById(id);
            return entity;
        }
        return null;
    }
}
