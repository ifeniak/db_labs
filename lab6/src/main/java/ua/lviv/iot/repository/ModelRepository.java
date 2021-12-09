package ua.lviv.iot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.domain.Model;

@Repository
public interface ModelRepository extends JpaRepository<Model, Integer> {
}
