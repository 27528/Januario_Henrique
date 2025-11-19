package Januario_Henrique.27528.q2;

import java.util.Date;

public class Passenger extends CabinCrew {
    private String passengerName;
    private int age;
    private String gender;
    private String contact;
    
    public Passenger(int id, Date createdDate, Date updatedDate,
                     String airportName, String code, String location,
                     String airlineName, String airlineCode, String contactEmail,
                     String flightNumber, String departure, String destination, double baseFare,
                     String pilotName, String licenseNumber, int experienceYears,
                     String crewName, String role, String shift,
                     String passengerName, int age, String gender, String contact) {
        super(id, createdDate, updatedDate, airportName, code, location,
              airlineName, airlineCode, contactEmail, flightNumber, departure, destination, baseFare,
              pilotName, licenseNumber, experienceYears, crewName, role, shift);
        
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be greater than 0");
        }
        if (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female") && 
            !gender.equalsIgnoreCase("Other")) {
            throw new IllegalArgumentException("Gender must be Male, Female, or Other");
        }
        
        this.passengerName = passengerName;
        this.age = age;
        this.gender = gender;
        this.contact = contact;
    }
    
    public String getPassengerName() { return passengerName; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getContact() { return contact; }
    
    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }
    
    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be greater than 0");
        }
        this.age = age;
    }
    
    public void setGender(String gender) {
        if (!gender.equalsIgnoreCase("Male") && !gender.equalsIgnoreCase("Female") && 
            !gender.equalsIgnoreCase("Other")) {
            throw new IllegalArgumentException("Gender must be Male, Female, or Other");
        }
        this.gender = gender;
    }
    
    public void setContact(String contact) {
        this.contact = contact;
    }
    
    public boolean isChild() {
        return age < 12;
    }
    
    public boolean isSenior() {
        return age >= 60;
    }
}
