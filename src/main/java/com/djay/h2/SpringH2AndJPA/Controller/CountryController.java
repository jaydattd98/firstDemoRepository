package com.djay.h2.SpringH2AndJPA.Controller;

import com.djay.h2.SpringH2AndJPA.Entity.Country;
import com.djay.h2.SpringH2AndJPA.Util.StringUtil;
import com.djay.h2.SpringH2AndJPA.repository.CountryRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@Component
@RestController
public class CountryController {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(CountryController.class);

    @Autowired
    private CountryRepository countryRepository;

    @PostMapping("/country")
    public ResponseEntity<String> createCountry (@RequestBody Country country) {
        String methodName = "CountryController#createCountry";
        log.info("Entering in the "+ methodName);
        countryRepository.saveCountry(country);
        log.info("Response Got is "+ country);
        return new ResponseEntity<String>("country created ", HttpStatus.CREATED);
    }

    @GetMapping("/country-list")
    public ResponseEntity<List<Country>> getAllCountryList (){
        String methodName = "CountryController#getAllCountryList";
        log.info("Inside the "+ methodName);
        List<Country> countryList = null;
        countryList = countryRepository.getAllCountryList();
        if (countryList.isEmpty()) {
            throw new NoSuchElementException(methodName);
        }
        log.info("Response Got is "+ countryList);
        return new ResponseEntity<List<Country>>(countryList, HttpStatus.OK);
    }

    @GetMapping("/country/{code}")
    public ResponseEntity<Country> getCountryByCode (@PathVariable String code) {
        String methodName = "CountryController#getCountryByCode";
        log.info("Inside the "+ methodName);
        Country country = null;
        validateInputeCode(code);
        country = countryRepository.getCountryByCode(code);
        log.info("Response get Country ="+country);
        return new ResponseEntity<>(country, HttpStatus.OK);
    }

    @DeleteMapping ("/country/{code}")
    public ResponseEntity<String> removeCountry (@PathVariable String code) {
        String methodName = "CountryController#createCountry";
        log.info("Entering in the "+ methodName);
        Country country = countryRepository.getCountryByCode(code);
        countryRepository.removeCountry(country);
        log.info("End the "+methodName+" Deleted the country..!!");
        return new ResponseEntity<String>("deleted", HttpStatus.OK);
    }
    private void validateInputeCode(String code) {
        String methodName = "CountryController#validateInputeCode";
        if(StringUtil.isNull(code)) {
            log.warn("Invalide Inpute Code="+code);
            throw new NullPointerException(methodName);
        }
    }
}
