package Januario_Henrique.27528.q4;

import java.util.Date;
import java.util.regex.Pattern;

public class Organization extends Entity {
    private String orgName;
    private String address;
    private String contactEmail;
    
    public Organization(int id, Date createdDate, Date updatedDate,
                       String orgName, String address, String contactEmail) {
        super(id, createdDate, updatedDate);
        
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (!Pattern.matches(emailRegex, contactEmail)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        
        this.orgName = orgName;
        this.address = address;
        this.contactEmail = contactEmail;
    }
    
    public String getOrgName() { return orgName; }
    public String getAddress() { return address; }
    public String getContactEmail() { return contactEmail; }
    
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public void setContactEmail(String contactEmail) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (!Pattern.matches(emailRegex, contactEmail)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.contactEmail = contactEmail;
    }
}
