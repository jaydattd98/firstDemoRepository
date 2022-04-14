package com.djay.h2.SpringH2AndJPA.repository;

import com.djay.h2.SpringH2AndJPA.Entity.Country;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CountryRepository {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(CountryRepository.class);

    @Autowired
    EntityManager em;

    public List<Country> getAllCountryList() {
        String methodName = "CountryService#getAllCountryList";
        log.info("Inside the " + methodName);
        List<Country> countries = null;
        TypedQuery<Country> query = em.createNamedQuery("Country.getAllCountries", Country.class);
        countries = query.getResultList();
        return countries;
    }

    public Country getCountryByCode(String code) {
        String methodName = "CountryRepository#getCountryByCode";
        log.info("Entering in the " + methodName);
        Country country = null;
        country = em.find(Country.class, code);
        return country;
    }

    public void saveCountry(Country country) {
        if (null == em.find(Country.class, country.getCode())) {
            em.persist(country);
        } else {
            em.merge(country);
        }
    }

    public void removeCountry(Country country) {
        em.remove(country);
    }
}
