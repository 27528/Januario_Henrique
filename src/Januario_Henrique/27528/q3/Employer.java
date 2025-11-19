package Januario_Henrique.27528.q3;

import java.util.Date;

public class Employer extends Taxpayer {
    private String employerName;
    private String employerTIN;
    private String contact;
    
    public Employer(int id, Date createdDate, Date updatedDate,
                   String authorityName, String region, String email,
                   String categoryName, double rate, String code,
                   String tin, String taxpayerName, String address,
                   String employerName, String employerTIN, String contact) {
        super(id, createdDate, updatedDate, authorityName, region, email,
              categoryName, rate, code, tin, taxpayerName, address);
        
        if (employerTIN == null || !employerTIN.matches("\\d{9}")) {
            throw new IllegalArgumentException("Employer TIN must be 9 digits");
        }
        if (contact == null || !contact.matches("\\d{10}")) {
            throw new IllegalArgumentException("Contact must be 10 digits");
        }
        
        this.employerName = employerName;
        this.employerTIN = employerTIN;
        this.contact = contact;
    }
    
    public String getEmployerName() { return employerName; }
    public String getEmployerTIN() { return employerTIN; }
    public String getContact() { return contact; }
    
    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }
    
    public void setEmployerTIN(String employerTIN) {
        if (employerTIN == null || !employerTIN.matches("\\d{9}")) {
            throw new IllegalArgumentException("Employer TIN must be 9 digits");
        }
        this.employerTIN = employerTIN;
    }
    
    public void setContact(String contact) {
        if (contact == null || !contact.matches("\\d{10}")) {
            throw new IllegalArgumentException("Contact must be 10 digits");
        }
        this.contact = contact;
    }
}
