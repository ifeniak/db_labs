package ua.lviv.iot.view;

import ua.lviv.iot.controller.Controller;
import ua.lviv.iot.controller.implementation.*;
import ua.lviv.iot.model.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class View {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Map<String, Printable> menu = new HashMap<String, Printable>();

    private final Controller<Model> modelController = new ModelController();
    private final Controller<Country> countryController = new CountryController();
    private final Controller<Airline> airlineController = new AirlineController();
    private final Controller<Plane> planeController = new PlaneController();
    private final Controller<City> cityController = new CityController();

    public View() {
        menu.put("11", this::getAllModels);
        menu.put("12", this::getModelById);
        menu.put("13", this::createModel);
        menu.put("14", this::updateModel);
        menu.put("15", this::deleteModel);

        menu.put("21", this::getAllCountries);
        menu.put("22", this::getCountryById);
        menu.put("23", this::createCountry);
        menu.put("24", this::updateCountry);
        menu.put("25", this::deleteCountry);

        menu.put("31", this::getAllAirlines);
        menu.put("32", this::getAirlineById);
        menu.put("33", this::createAirline);
        menu.put("34", this::updateAirline);
        menu.put("35", this::deleteAirline);

        menu.put("41", this::getAllPlanes);
        menu.put("42", this::getPlaneById);
        menu.put("43", this::createPlane);
        menu.put("44", this::updatePlane);
        menu.put("45", this::deletePlane);

        menu.put("51", this::getAllCity);
        menu.put("52", this::getCityById);
        menu.put("53", this::createCity);
        menu.put("54", this::updateCity);
        menu.put("55", this::deleteCity);
    }

    // -----------------------------------------------------------------------------------------------------------------

    private void getAllModels() throws SQLException {
        System.out.println("");
        modelController.findAll().forEach(System.out::println);
        System.out.println("");
    }

    private void getModelById() throws SQLException {
        System.out.println("");
        Integer id = readId("Type id:");
        System.out.println("\n" + modelController.findById(id));
        System.out.println("");
    }

    private void createModel() throws SQLException {
        System.out.println("");
        modelController.create(getModelFromInput());
        System.out.println("");
    }

    private void updateModel() throws SQLException{
        System.out.println("");
        Integer id = readId("Type id: ");
        Model model = getModelFromInput();
        model.setId(id);
        modelController.update(model);
        System.out.println("");
    }

    private void deleteModel() throws SQLException {
        System.out.println("");
        Integer id = readId("Type id: ");
        modelController.delete(id);
        System.out.println("");
    }

    private Model getModelFromInput() throws SQLException {
        System.out.println("Type name: ");
        String name = scanner.nextLine().replaceAll(" ", "");
        System.out.println("Type height: ");
        Double height = Double.parseDouble(scanner.nextLine().replaceAll(" ", ""));
        System.out.println("Type length: ");
        Double length = Double.parseDouble(scanner.nextLine().replaceAll(" ", ""));
        System.out.println("Type width");
        Double width = Double.parseDouble(scanner.nextLine().replaceAll(" ", ""));
        System.out.println("Type destination: ");
        String destination = scanner.nextLine().replaceAll(" ", "");
        System.out.println("Type color: ");
        String color = scanner.nextLine().replaceAll(" ", "");

        return new Model(name, height, length, width, destination, color);
    }

    // -----------------------------------------------------------------------------------------------------------------

    private void getAllCountries() throws SQLException {
        System.out.println("");
        countryController.findAll().forEach(System.out::println);
        System.out.println("");
    }

    private void getCountryById() throws SQLException {
        System.out.println("");
        String name = readName("Type name:");
        System.out.println("\n" + countryController.findById(name));
        System.out.println("");
    }

    private void createCountry() throws SQLException{
        System.out.println("");
        String name = readName("Type name: ");
        Country country = getCountryFromInput();
        country.setName(name);
        countryController.create(country);
        System.out.println("");
    }

    private void updateCountry() throws SQLException{
        System.out.println("");
        String name = readName("Type name: ");
        Country country = getCountryFromInput();
        country.setName(name);
        countryController.update(country);
        System.out.println("");
    }

    private void deleteCountry() throws SQLException {
        System.out.println("");
        String name = readName("Type name: ");
        countryController.delete(name);
        System.out.println("");
    }

    private Country getCountryFromInput() throws SQLException {
        System.out.println("Type gdp: ");
        Integer gdp = Integer.parseInt(scanner.nextLine().replaceAll(" ", ""));
        System.out.println("Type size: ");
        Double size = Double.parseDouble(scanner.nextLine().replaceAll(" ", ""));
        System.out.println("Type population: ");
        Integer population = Integer.parseInt(scanner.nextLine().replaceAll(" ", ""));

        return new Country(gdp, size, population);
    }

    // -----------------------------------------------------------------------------------------------------------------

    private void getAllAirlines() throws SQLException {
        System.out.println("");
        airlineController.findAll().forEach(System.out::println);
        System.out.println("");
    }

    private void getAirlineById() throws SQLException {
        System.out.println("");
        Integer id = readId("Type id: ");
        System.out.println("\n" + airlineController.findById(id));
        System.out.println("");
    }

    private void createAirline() throws SQLException {
        System.out.println("");
        airlineController.create(getAirlineFromInput());
        System.out.println("");
    }

    private void updateAirline() throws SQLException {
        System.out.println("");
        Integer id = readId("Type id: ");
        Airline airline = getAirlineFromInput();
        airline.setId(id);
        airlineController.update(airline);
        System.out.println("");
    }

    private void deleteAirline() throws SQLException {
        System.out.println("");
        Integer id = readId("Type id: ");
        airlineController.delete(id);
        System.out.println("");
    }

    private Airline getAirlineFromInput() {
        System.out.println("Type name:");
        String name = scanner.nextLine().replaceAll(" ", "");
        System.out.println("Type capitalization: ");
        Double capitalization = Double.parseDouble(scanner.nextLine().replaceAll(" ", ""));
        System.out.println("Type country_name: ");
        String country_name = scanner.nextLine().replaceAll(" ", "");

        return new Airline(name, capitalization, country_name);
    }

    // -----------------------------------------------------------------------------------------------------------------

    private void getAllPlanes() throws SQLException {
        System.out.println("");
        planeController.findAll().forEach(System.out::println);
        System.out.println("");
    }

    private void getPlaneById() throws SQLException {
        System.out.println("");
        Integer id = readId("Type id: ");
        System.out.println("\n" + planeController.findById(id));
        System.out.println("");
    }

    private void createPlane() throws SQLException {
        System.out.println("");
        planeController.create(getPlaneFromInput());
        System.out.println("");
    }

    private void updatePlane() throws SQLException {
        System.out.println("");
        Integer id = readId("Type id: ");
        Plane plane = getPlaneFromInput();
        plane.setId(id);
        planeController.update(plane);
        System.out.println("");
    }

    private void deletePlane() throws SQLException {
        System.out.println("");
        Integer id = readId("Type id");
        planeController.delete(id);
        System.out.println("");
    }

    private Plane getPlaneFromInput() {
        System.out.println("Type name: ");
        String name = scanner.nextLine().replaceAll(" ", "");
        System.out.println("Type model_id: ");
        Integer model_id = Integer.parseInt(scanner.nextLine().replaceAll(" ", ""));
        System.out.println("Type airline_id: ");
        Integer airline_id = Integer.parseInt(scanner.nextLine().replaceAll(" ", ""));
        System.out.println("Type kilometrage: ");
        Integer kilometrage = Integer.parseInt(scanner.nextLine().replaceAll(" ", ""));
        System.out.println("Type aircraft_registration: ");
        String aircraft_registration = scanner.nextLine().replaceAll(" ", "");

        return new Plane(name, model_id, airline_id, kilometrage, aircraft_registration);
    }

    // -----------------------------------------------------------------------------------------------------------------

    public void getAllCity() throws SQLException {
        System.out.println();
        cityController.findAll().forEach(System.out::println);
        System.out.println();
    }

    public void getCityById() throws SQLException {
        System.out.println();
        String name = readName("Type name: ");
        System.out.println("\n" + cityController.findById(name));
        System.out.println();
    }

    public void createCity() throws SQLException {
        System.out.println();
        String name = readName("Type name: ");
        City city = getCityFromInput();
        city.setName(name);
        cityController.create(city);
        System.out.println();
    }

    public void updateCity() throws SQLException {
        System.out.println();
        String name = readName("Type name: ");
        City city = getCityFromInput();
        city.setName(name);
        cityController.update(city);
        System.out.println();
    }

    public void deleteCity() throws SQLException {
        System.out.println();
        String name = readName("Type name: ");
        cityController.delete(name);
        System.out.println();
    }

    private City getCityFromInput() {
        System.out.println("Type population: ");
        Integer population = Integer.parseInt(scanner.nextLine().replaceAll(" ", ""));
        System.out.println("Type status: ");
        String status = scanner.nextLine().replaceAll(" ", "");
        System.out.println("Type country_name: ");
        String country_name = scanner.nextLine().replaceAll(" ", "");

        return new City(population, status, country_name);
    }

    // -----------------------------------------------------------------------------------------------------------------

    private Integer readId(String msg) {
        System.out.println(msg);
        return Integer.parseInt(scanner.nextLine().replaceAll(" ", ""));
    }

    private String readName(String msg) {
        System.out.println(msg);
        return scanner.nextLine().replaceAll(" ", "");
    }

    public void show() throws SQLException {
        Menu.displayMenu();
        String input = scanner.nextLine().replaceAll(" ", "");

        while (!input.equals("QUIT")) {
            menu.get(input).print();
            input = scanner.nextLine().replaceAll(" ", "");
        }
    }
}
