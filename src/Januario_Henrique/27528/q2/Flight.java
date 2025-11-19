package Januario_Henrique.27528.q2;

import java.util.Date;

public class Flight extends Airline {
    private String flightNumber;
    private String departure;
    private String destination;
    private double baseFare;
    
    public Flight(int id, Date createdDate, Date updatedDate,
                  String airportName, String code, String location,
                  String airlineName, String airlineCode, String contactEmail,
                  String flightNumber, String departure, String destination, double baseFare) {
        super(id, createdDate, updatedDate, airportName, code, location, 
              airlineName, airlineCode, contactEmail);
        
        if (flightNumber == null || flightNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Flight number cannot be empty");
        }
        if (departure == null || departure.trim().isEmpty()) {
            throw new IllegalArgumentException("Departure cannot be empty");
        }
        if (destination == null || destination.trim().isEmpty()) {
            throw new IllegalArgumentException("Destination cannot be empty");
        }
        if (baseFare <= 0) {
            throw new IllegalArgumentException("Base fare must be greater than 0");
        }
        
        this.flightNumber = flightNumber;
        this.departure = departure;
        this.destination = destination;
        this.baseFare = baseFare;
    }
    
    public String getFlightNumber() { return flightNumber; }
    public String getDeparture() { return departure; }
    public String getDestination() { return destination; }
    public double getBaseFare() { return baseFare; }
    
    public void setFlightNumber(String flightNumber) {
        if (flightNumber == null || flightNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Flight number cannot be empty");
        }
        this.flightNumber = flightNumber;
    }
    
    public void setDeparture(String departure) {
        if (departure == null || departure.trim().isEmpty()) {
            throw new IllegalArgumentException("Departure cannot be empty");
        }
        this.departure = departure;
    }
    
    public void setDestination(String destination) {
        if (destination == null || destination.trim().isEmpty()) {
            throw new IllegalArgumentException("Destination cannot be empty");
        }
        this.destination = destination;
    }
    
    public void setBaseFare(double baseFare) {
        if (baseFare <= 0) {
            throw new IllegalArgumentException("Base fare must be greater than 0");
        }
        this.baseFare = baseFare;
    }
}