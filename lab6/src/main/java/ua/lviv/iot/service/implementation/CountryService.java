package ua.lviv.iot.service.implementation;

import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ua.lviv.iot.domain.Country;
import ua.lviv.iot.repository.CountryRepository;
import ua.lviv.iot.service.AbstractService;

@AllArgsConstructor
@Service
public class CountryService extends AbstractService<Country, String> {
    public CountryRepository countryRepository;

    @Override
    protected JpaRepository<Country, String> getRepository() {
        return countryRepository;
    }

    @Override
    public Country update(String name, Country country) {
        if (getRepository().findById(name).isPresent()) {
            country.setName(name);
            return getRepository().save(country);
        }
        return null;
    }

    @Override
    public Country create(Country country) {
        country.setName(country.getName());
        return getRepository().save(country);
    }
}
