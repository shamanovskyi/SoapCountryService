package ua.artcode.repository;

import ua.artcode.model.Country;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

@Component
public class CountryRepository {

    private List<Country> countries;

    @PostConstruct
    public void initData(){
        countries = new ArrayList<Country>();

        Country Spain = new Country("Spain", "Madrid", 46.77, 505.99);
        Country Poland = new Country("Poland", "Warsaw", 38.48, 312.68);
        Country UnitedKingdom = new Country("United Kingdom", "London", 65.11, 242.49);

        countries.add(Spain);
        countries.add(Poland);
        countries.add(UnitedKingdom);
    }

    public boolean addCountry(Country country){
        return countries.add(country);
    }

    public Country getCountry(String name){
        for (Country country : countries) {
            if(country.getName().equals(name)) return country;
        }
        return null;
    }

    public List<Country> getAll(){
        return countries;
    }

}
