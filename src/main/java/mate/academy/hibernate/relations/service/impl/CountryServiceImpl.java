package mate.academy.hibernate.relations.service.impl;

import mate.academy.hibernate.relations.dao.CountryDao;
import mate.academy.hibernate.relations.exception.DataProcessingException;
import mate.academy.hibernate.relations.model.Country;
import mate.academy.hibernate.relations.service.CountryService;

public class CountryServiceImpl implements CountryService {
    private CountryDao countryDao;

    public CountryServiceImpl(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    @Override
    public Country add(Country country) {
        if (country == null) {
            throw new DataProcessingException("Cannot add null data");
        }
        countryDao.add(country);
        return country;
    }

    @Override
    public Country get(Long id) {
        if (id == null) {
            throw new DataProcessingException("Cannot get by null id");
        }
        return countryDao.get(id).orElseThrow(DataProcessingException::new);
    }
}
