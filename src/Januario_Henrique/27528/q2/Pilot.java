package Januario_Henrique.27528.q2;

import java.util.Date;

public class Pilot extends Flight {
    private String pilotName;
    private String licenseNumber;
    private int experienceYears;
    
    public Pilot(int id, Date createdDate, Date updatedDate,
                 String airportName, String code, String location,
                 String airlineName, String airlineCode, String contactEmail,
                 String flightNumber, String departure, String destination, double baseFare,
                 String pilotName, String licenseNumber, int experienceYears) {
        super(id, createdDate, updatedDate, airportName, code, location,
              airlineName, airlineCode, contactEmail, flightNumber, departure, destination, baseFare);
        
        if (licenseNumber == null || licenseNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("License number cannot be empty");
        }
        if (experienceYears < 2) {
            throw new IllegalArgumentException("Pilot must have at least 2 years experience");
        }
        
        this.pilotName = pilotName;
        this.licenseNumber = licenseNumber;
        this.experienceYears = experienceYears;
    }
    
    public String getPilotName() { return pilotName; }
    public String getLicenseNumber() { return licenseNumber; }
    public int getExperienceYears() { return experienceYears; }
    
    public void setPilotName(String pilotName) {
        this.pilotName = pilotName;
    }
    
    public void setLicenseNumber(String licenseNumber) {
        if (licenseNumber == null || licenseNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("License number cannot be empty");
        }
        this.licenseNumber = licenseNumber;
    }
    
    public void setExperienceYears(int experienceYears) {
        if (experienceYears < 2) {
            throw new IllegalArgumentException("Pilot must have at least 2 years experience");
        }
        this.experienceYears = experienceYears;
    }
    
    public boolean isSeniorPilot() {
        return experienceYears >= 10;
    }
}