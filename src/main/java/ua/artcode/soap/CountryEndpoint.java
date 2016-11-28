package ua.artcode.soap;




import ua.artcode.repository.CountryRepository;
import ua.artcode.service_country.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ua.artcode.service_country.Country;

import java.util.ArrayList;
import java.util.List;


@Endpoint
public class CountryEndpoint {

    private static final String NAMESPACE_URI = "http://www.artcode.ua/service-country";

    @Autowired
    private CountryRepository countryRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        ua.artcode.model.Country modelCountry = countryRepository.getCountry(request.getName());
        Country country = new Country();
        country.setName(modelCountry.getName());
        country.setCapital(modelCountry.getCapital());
        country.setArea(modelCountry.getArea());
        country.setPopulation(modelCountry.getPopulation());

        response.setCountry(country);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addCountryRequest")
    @ResponsePayload
    public AddCountryResponse addCountry(@RequestPayload AddCountryRequest request){
        AddCountryResponse response = new AddCountryResponse();
        Country newCountry = request.getCountry();
        response.setBoolean(countryRepository.addCountry(new ua.artcode.model.Country().setCountry(newCountry)));
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllCountriesRequest")
    @ResponsePayload
    public GetAllCountriesResponse getAllCountries(@RequestPayload GetAllCountriesRequest request){
        GetAllCountriesResponse response = new GetAllCountriesResponse();
        List<ua.artcode.model.Country> oldCountries = countryRepository.getAll();
        List<Country> newCountries = new ArrayList<>();
        for (ua.artcode.model.Country country : oldCountries) {
            newCountries.add(ua.artcode.model.Country.setNewCountry(country));
        }
        response.getCountries().addAll(newCountries);
        return response;
    }

}
