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
    private final Controller<Airport> airportController = new AirportController();
    private final Controller<Flight> flightController = new FlightController();
    private final Controller<Route> routeController = new RouteController();
    private final Controller<NongovernmentalTerritories> nongovernmental_territoriesController =
            new NongovernmentalTerritoriesController();
    private final Controller<Location> locationController = new LocationController();
    private final Controller<PlaneFlightHistory> plane_flight_historyController = new PlaneFlightHistoryController()
            ;

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

        menu.put("61", this::getAllAirports);
        menu.put("62", this::getAirportById);
        menu.put("63", this::createAirport);
        menu.put("64", this::updateAirport);
        menu.put("65", this::deleteAirport);

        menu.put("71", this::getAllFlights);
        menu.put("72", this::getFlightById);
        menu.put("73", this::createFlight);
        menu.put("74", this::updateFlight);
        menu.put("75", this::deleteFlight);

        menu.put("81", this::getAllRoutes);
        menu.put("82", this::getRouteById);
        menu.put("83", this::createRoute);
        menu.put("84", this::updateRoute);
        menu.put("85", this::deleteRoute);

        menu.put("91", this::getAllNongovernmentalTerritories);
        menu.put("92", this::getNongovernmentalTerritoriesById);
        menu.put("93", this::createNongovernmentalTerritories);
        menu.put("94", this::updateNongovernmentalTerritories);
        menu.put("95", this::deleteNongovernmentalTerritories);

        menu.put("101", this::getAllLocations);
        menu.put("102", this::getLocationById);
        menu.put("103", this::createLocation);
        menu.put("104", this::updateLocation);
        menu.put("105", this::deleteLocation);

        menu.put("111", this::getAllPlane_flight_histories);
        menu.put("112", this::getPlaneFlightHistoryById);
        menu.put("113", this::createPlaneFlightHistory);
        menu.put("114", this::updatePlaneFlightHistory);
        menu.put("115", this::deletePlaneFlightHistory);

    }

    // -----------------------------------------------------------------------------------------------------------------


    private void getAllModels() throws SQLException {
        System.out.println();
        modelController.findAll().forEach(System.out::println);
        System.out.println();
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

    private Model getModelFromInput() {
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
        System.out.println();
        airlineController.findAll().forEach(System.out::println);
        System.out.println();
    }

    private void getAirlineById() throws SQLException {
        System.out.println();
        Integer id = readId("Type id: ");
        System.out.println("\n" + airlineController.findById(id));
        System.out.println();
    }

    private void createAirline() throws SQLException {
        System.out.println();
        airlineController.create(getAirlineFromInput());
        System.out.println();
    }

    private void updateAirline() throws SQLException {
        System.out.println();
        Integer id = readId("Type id: ");
        Airline airline = getAirlineFromInput();
        airline.setId(id);
        airlineController.update(airline);
        System.out.println();
    }

    private void deleteAirline() throws SQLException {
        System.out.println();
        Integer id = readId("Type id: ");
        airlineController.delete(id);
        System.out.println();
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

    public void getAllAirports() throws SQLException {
        System.out.println();
        airportController.findAll().forEach(System.out::println);
        System.out.println();
    }

    public void getAirportById() throws SQLException {
        System.out.println();
        String name = readName("Type name:");
        System.out.println("\n" + airportController.findById(name));
        System.out.println();
    }

    public void createAirport() throws SQLException {
        System.out.println();
        String name = readName("Type name: ");
        Airport airport = getAirportFromInput();
        airport.setName(name);
        airportController.create(airport);
        System.out.println();
    }

    private void updateAirport() throws SQLException {
        System.out.println();
        String name = readName("Type name: ");
        Airport airport = getAirportFromInput();
        airport.setName(name);
        airportController.update(airport);
        System.out.println();
    }

    private void deleteAirport() throws SQLException {
        System.out.println("");
        String name = readName("Type name: ");
        airportController.delete(name);
        System.out.println("");
    }

    private Airport getAirportFromInput() {
        System.out.println("Type quality: ");
        String quality = scanner.nextLine().replaceAll(" ", "");
        System.out.println("Type planes_capacity: ");
        Integer planes_capacity = Integer.parseInt(scanner.nextLine().replaceAll(" ", ""));
        System.out.println("Type city_name: ");
        String city_name = scanner.nextLine().replaceAll(" ", "");

        return new Airport(quality, planes_capacity, city_name);
    }

    // -----------------------------------------------------------------------------------------------------------------

    private void getAllFlights() throws SQLException {
        System.out.println();
        flightController.findAll().forEach(System.out::println);
        System.out.println();
    }

    private void getFlightById() throws SQLException {
        System.out.println();
        Integer id = readId("Type id: ");
        System.out.println("\n" + flightController.findById(id));
        System.out.println();
    }

    private void createFlight() throws SQLException {
        System.out.println();
        flightController.create(getFlightFromInput());
        System.out.println();
    }

    private void updateFlight() throws SQLException {
        System.out.println();
        Integer id = readId("Type id: ");
        Flight flight = getFlightFromInput();
        flight.setId(id);
        flightController.update(flight);
        System.out.println();
    }

    private void deleteFlight() throws SQLException {
        System.out.println();
        Integer id = readId("Type id: ");
        flightController.delete(id);
        System.out.println();
    }

    public Flight getFlightFromInput() {
        System.out.println("Type name:");
        String name = scanner.nextLine().replaceAll(" ", "");
        System.out.println("Type airport_departure: ");
        String airport_departure = scanner.nextLine().replaceAll(" ", "");
        System.out.println("Type airport_arrival: ");
        String airport_arrival = scanner.nextLine().replaceAll(" ", "");

        return new Flight(name, airport_departure, airport_arrival);

    }

    // -----------------------------------------------------------------------------------------------------------------

    private void getAllRoutes() throws SQLException {
        System.out.println();
        routeController.findAll().forEach(System.out::println);
        System.out.println();
    }

    private void getRouteById() throws SQLException {
        System.out.println();
        Integer id = readId("Type id: ");
        System.out.println("\n" + routeController.findById(id));
        System.out.println();
    }

    private void createRoute() throws SQLException {
        System.out.println();
        routeController.create(getRouteFromInput());
        System.out.println();
    }

    private void updateRoute() throws SQLException {
        System.out.println();
        Integer id = readId("Type id: ");
        Route route = getRouteFromInput();
        route.setId(id);
        routeController.update(route);
        System.out.println();
    }

    private void deleteRoute() throws SQLException {
        System.out.println();
        Integer id = readId("Type id: ");
        routeController.delete(id);
        System.out.println();
    }

    private Route getRouteFromInput() {
        System.out.println("Type name:");
        String name = scanner.nextLine().replaceAll(" ", "");
        System.out.println("Type length: ");
        Integer length = Integer.parseInt(scanner.nextLine().replaceAll(" ", ""));
        System.out.println("Type duration: ");
        Double duration = Double.parseDouble(scanner.nextLine().replaceAll(" ", ""));
        System.out.println("Type danger_level: ");
        Integer danger_level = Integer.parseInt(scanner.nextLine().replaceAll(" ", ""));
        System.out.println("Type is_direct: ");
        Byte is_direct = Byte.parseByte(scanner.nextLine().replaceAll(" ", ""));
        System.out.println("Type flight_id: ");
        Integer flight_id = Integer.parseInt(scanner.nextLine().replaceAll(" ", ""));

        return new Route(name, length, duration, danger_level, is_direct, flight_id);
    }

    // -----------------------------------------------------------------------------------------------------------------

    public void getAllNongovernmentalTerritories() throws SQLException {
        System.out.println();
        nongovernmental_territoriesController.findAll().forEach(System.out::println);
        System.out.println();
    }

    public void getNongovernmentalTerritoriesById() throws SQLException {
        System.out.println();
        String name = readName("Type name: ");
        System.out.println("\n" + nongovernmental_territoriesController.findById(name));
        System.out.println();
    }

    public void createNongovernmentalTerritories() throws SQLException {
        System.out.println();
        String name = readName("Type name: ");
        NongovernmentalTerritories nongovernmental_territories = getNongovernmentalTerritoriesFromInput();
        nongovernmental_territories.setName(name);
        nongovernmental_territoriesController.create(nongovernmental_territories);
        System.out.println();
    }

    public void updateNongovernmentalTerritories() throws SQLException {
        System.out.println();
        String name = readName("Type name: ");
        NongovernmentalTerritories nongovernmental_territories = getNongovernmentalTerritoriesFromInput();
        nongovernmental_territories.setName(name);
        nongovernmental_territoriesController.update(nongovernmental_territories);
        System.out.println();
    }

    public void deleteNongovernmentalTerritories() throws SQLException {
        System.out.println();
        String name = readName("Type name: ");
        nongovernmental_territoriesController.delete(name);
        System.out.println();
    }

    private NongovernmentalTerritories getNongovernmentalTerritoriesFromInput() {
        System.out.println("Type type: ");
        String status = scanner.nextLine().replaceAll(" ", "");
        System.out.println("Type danger_level: ");
        String danger_level = scanner.nextLine().replaceAll(" ", "");

        return new NongovernmentalTerritories(status, danger_level);
    }

    // -----------------------------------------------------------------------------------------------------------------

    private void getAllLocations() throws SQLException {
        System.out.println();
        locationController.findAll().forEach(System.out::println);
        System.out.println();
    }

    private void getLocationById() throws SQLException {
        System.out.println();
        Integer id = readId("Type id: ");
        System.out.println("\n" + locationController.findById(id));
        System.out.println();
    }

    private void createLocation() throws SQLException {
        System.out.println();
        locationController.create(getLocationFromInput());
        System.out.println();
    }

    private void updateLocation() throws SQLException {
        System.out.println();
        Integer id = readId("Type id: ");
        Location location = getLocationFromInput();
        location.setId(id);
        locationController.update(location);
        System.out.println();
    }

    private void deleteLocation() throws SQLException {
        System.out.println();
        Integer id = readId("Type id: ");
        locationController.delete(id);
        System.out.println();
    }

    private Location getLocationFromInput() {
        System.out.println("Type speed: ");
        Double speed = Double.parseDouble(scanner.nextLine().replaceAll(" ", ""));
        System.out.println("Type latitude: ");
        Double latitude = Double.parseDouble(scanner.nextLine().replaceAll(" ", ""));
        System.out.println("Type longitude: ");
        Double longitude = Double.parseDouble(scanner.nextLine().replaceAll(" ", ""));
        System.out.println("Type governmental_territories: ");
        String governmental_territories = scanner.nextLine().replaceAll(" ", "");
        System.out.println("Type nongovernmental_territories");
        String nongovernmental_territories = scanner.nextLine().replaceAll(" ", "");
        System.out.println("Type plane_id: ");
        Integer plane_id = Integer.parseInt(scanner.nextLine().replaceAll(" ", ""));

        return new Location(speed, latitude, longitude, governmental_territories, nongovernmental_territories, plane_id);
    }

    // -----------------------------------------------------------------------------------------------------------------

    private void getAllPlane_flight_histories() throws SQLException {
        System.out.println();
        plane_flight_historyController.findAll().forEach(System.out::println);
        System.out.println();
    }

    private void getPlaneFlightHistoryById() throws SQLException {
        System.out.println();
        Integer firstId = readId("Type first_id: ");
        Integer secondId = readId("Type second_id: ");
        System.out.println("\n" + plane_flight_historyController.findById(firstId, secondId));
        System.out.println();
    }

    private void createPlaneFlightHistory() throws SQLException {
        System.out.println();
        plane_flight_historyController.create(getPlaneFlightHistoryFromInput());
        System.out.println();
    }

    private void updatePlaneFlightHistory() {
        System.out.println("You can't update value in this table");
    }

    private void deletePlaneFlightHistory() throws SQLException {
        System.out.println();
        Integer firstId = readId("Type first_id: ");
        Integer secondId = readId("Type second_id: ");
        plane_flight_historyController.delete(firstId, secondId);
        System.out.println();
    }

    private PlaneFlightHistory getPlaneFlightHistoryFromInput() {
        System.out.println("Type first_id: ");
        Integer firstId = Integer.parseInt(scanner.nextLine().replaceAll(" ", ""));
        System.out.println("Type second_id: ");
        Integer secondId = Integer.parseInt(scanner.nextLine().replaceAll(" ", ""));
        return new PlaneFlightHistory(firstId, secondId);
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

