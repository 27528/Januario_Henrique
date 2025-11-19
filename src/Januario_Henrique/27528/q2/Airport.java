package Januario_Henrique.27528.q2;

import java.util.Date;

public class Airport extends Entity {
    private String airportName;
    private String code;
    private String location;
    
    public Airport(int id, Date createdDate, Date updatedDate,
                   String airportName, String code, String location) {
        super(id, createdDate, updatedDate);
        
        if (code == null || !code.matches("[A-Z]{3}")) {
            throw new IllegalArgumentException("Airport code must be 3 uppercase letters");
        }
        
        this.airportName = airportName;
        this.code = code;
        this.location = location;
    }
    
    public String getAirportName() { return airportName; }
    public String getCode() { return code; }
    public String getLocation() { return location; }
    
    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }
    
    public void setCode(String code) {
        if (code == null || !code.matches("[A-Z]{3}")) {
            throw new IllegalArgumentException("Airport code must be 3 uppercase letters");
        }
        this.code = code;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
}