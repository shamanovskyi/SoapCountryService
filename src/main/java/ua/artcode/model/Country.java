package ua.artcode.model;

public class Country {

    private String name;
    private String capital;
    private double population;
    private double area;

    public Country() {
    }

    public Country(String name, String capital, double population, double area) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
    }

    public Country setCountry(ua.artcode.service_country.Country country){
        Country res = new Country();
        res.setPopulation(country.getPopulation());
        res.setArea(country.getArea());
        res.setCapital(country.getCapital());
        res.setName(country.getName());
        return res;
    }

    public static ua.artcode.service_country.Country setNewCountry(Country country){
        ua.artcode.service_country.Country res = new ua.artcode.service_country.Country();
        res.setPopulation(country.getPopulation());
        res.setArea(country.getArea());
        res.setCapital(country.getCapital());
        res.setName(country.getName());
        return res;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public double getPopulation() {
        return population;
    }

    public void setPopulation(double population) {
        this.population = population;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", population=" + population +
                ", area=" + area +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (name != null ? !name.equals(country.name) : country.name != null) return false;
        return capital != null ? capital.equals(country.capital) : country.capital == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (capital != null ? capital.hashCode() : 0);
        return result;
    }
}
