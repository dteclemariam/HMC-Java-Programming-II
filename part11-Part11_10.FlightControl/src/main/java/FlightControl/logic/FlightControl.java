package FlightControl.logic;

import FlightControl.domain.Airplane;
import FlightControl.domain.Flight;
import FlightControl.domain.Place;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FlightControl {
    private Map<String, Airplane> airplanes;
    private Map<String, Flight> flights;
    private Map<String, Place> airports;

    public FlightControl(){
        this.airplanes = new HashMap<>();
        this.flights = new HashMap<>();
        this.airports = new HashMap<>();
    }

    public void addAirplane(String ID, int capacity){
        Airplane airplane = new Airplane(ID, capacity);
        this.airplanes.putIfAbsent(airplane.getID(), airplane);
    }

    public void addFlight(Airplane airplane, String departureID, String targetID){
        this.airports.putIfAbsent(departureID, new Place(departureID));
        this.airports.putIfAbsent(targetID, new Place(targetID));
        Flight flight = new Flight(airplane, airports.get(departureID), airports.get(targetID));
        this.flights.putIfAbsent(flight.toString(), flight);
    }

    public Collection<Airplane> getAirplanes(){
        return this.airplanes.values();
    }

    public Collection<Flight> getFlights(){
        return this.flights.values();
    }

    public Airplane getAirplane(String ID){
        return this.airplanes.get(ID);
    }
}
