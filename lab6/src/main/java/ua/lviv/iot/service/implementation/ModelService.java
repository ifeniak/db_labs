package ua.lviv.iot.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Model;
import ua.lviv.iot.repository.ModelRepository;
import ua.lviv.iot.service.AbstractService;

@AllArgsConstructor
@Service
public class ModelService extends AbstractService<Model, Integer> {
    public ModelRepository modelRepository;

    @Override
    protected JpaRepository<Model, Integer> getRepository() {
        return modelRepository;
    }

    @Override
    public Model update(Integer id, Model model) {
        if (getRepository().findById(id).isPresent()) {
            model.setId(id);
            return getRepository().save(model);
        }
        return null;
    }
}
