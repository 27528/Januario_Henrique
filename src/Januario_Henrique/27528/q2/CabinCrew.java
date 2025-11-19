package Januario_Henrique.27528.q2;

import java.util.Date;

public class CabinCrew extends Pilot {
    private String crewName;
    private String role;
    private String shift;
    
    public CabinCrew(int id, Date createdDate, Date updatedDate,
                     String airportName, String code, String location,
                     String airlineName, String airlineCode, String contactEmail,
                     String flightNumber, String departure, String destination, double baseFare,
                     String pilotName, String licenseNumber, int experienceYears,
                     String crewName, String role, String shift) {
        super(id, createdDate, updatedDate, airportName, code, location,
              airlineName, airlineCode, contactEmail, flightNumber, departure, destination, baseFare,
              pilotName, licenseNumber, experienceYears);
        
        if (role == null || role.trim().isEmpty()) {
            throw new IllegalArgumentException("Role cannot be empty");
        }
        if (!shift.equals("Day") && !shift.equals("Night")) {
            throw new IllegalArgumentException("Shift must be 'Day' or 'Night'");
        }
        
        this.crewName = crewName;
        this.role = role;
        this.shift = shift;
    }
    
    public String getCrewName() { return crewName; }
    public String getRole() { return role; }
    public String getShift() { return shift; }
    
    public void setCrewName(String crewName) {
        this.crewName = crewName;
    }
    
    public void setRole(String role) {
        if (role == null || role.trim().isEmpty()) {
            throw new IllegalArgumentException("Role cannot be empty");
        }
        this.role = role;
    }
    
    public void setShift(String shift) {
        if (!shift.equals("Day") && !shift.equals("Night")) {
            throw new IllegalArgumentException("Shift must be 'Day' or 'Night'");
        }
        this.shift = shift;
    }
    
    public boolean isSeniorCrew() {
        return role.equalsIgnoreCase("Chief Purser") || 
               role.equalsIgnoreCase("Senior Flight Attendant");
    }
}