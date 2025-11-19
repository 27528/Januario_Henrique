package Januario_Henrique.27528.q2;

import java.util.Date;
import java.util.regex.Pattern;

public class Airline extends Airport {
    private String airlineName;
    private String airlineCode;
    private String contactEmail;
    
    public Airline(int id, Date createdDate, Date updatedDate,
                   String airportName, String code, String location,
                   String airlineName, String airlineCode, String contactEmail) {
        super(id, createdDate, updatedDate, airportName, code, location);
        
        if (airlineCode == null || airlineCode.length() < 2 || airlineCode.length() > 4) {
            throw new IllegalArgumentException("Airline code must be 2-4 letters");
        }
        
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (!Pattern.matches(emailRegex, contactEmail)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        
        this.airlineName = airlineName;
        this.airlineCode = airlineCode;
        this.contactEmail = contactEmail;
    }
    
    public String getAirlineName() { return airlineName; }
    public String getAirlineCode() { return airlineCode; }
    public String getContactEmail() { return contactEmail; }
    
    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }
    
    public void setAirlineCode(String airlineCode) {
        if (airlineCode == null || airlineCode.length() < 2 || airlineCode.length() > 4) {
            throw new IllegalArgumentException("Airline code must be 2-4 letters");
        }
        this.airlineCode = airlineCode;
    }
    
    public void setContactEmail(String contactEmail) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (!Pattern.matches(emailRegex, contactEmail)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.contactEmail = contactEmail;
    }
}
