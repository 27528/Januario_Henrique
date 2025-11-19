package Januario_Henrique.27528.q6;

import java.util.Date;
import java.util.regex.Pattern;

public class Organization extends Entity {
    private String orgName;
    private String orgCode;
    private String rssbNumber;
    private String contactEmail;
    
    public Organization(int id, Date createdDate, Date updatedDate,
                       String orgName, String orgCode, String rssbNumber, String contactEmail) {
        super(id, createdDate, updatedDate);
        
        if (orgCode == null || orgCode.length() < 3) {
            throw new IllegalArgumentException("Organization code must be at least 3 characters");
        }
        if (rssbNumber == null || !rssbNumber.matches("\\d{8}")) {
            throw new IllegalArgumentException("RSSB number must be 8 digits");
        }
        
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (!Pattern.matches(emailRegex, contactEmail)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        
        this.orgName = orgName;
        this.orgCode = orgCode;
        this.rssbNumber = rssbNumber;
        this.contactEmail = contactEmail;
    }
    
    public String getOrgName() { return orgName; }
    public String getOrgCode() { return orgCode; }
    public String getRssbNumber() { return rssbNumber; }
    public String getContactEmail() { return contactEmail; }
    
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
    
    public void setOrgCode(String orgCode) {
        if (orgCode == null || orgCode.length() < 3) {
            throw new IllegalArgumentException("Organization code must be at least 3 characters");
        }
        this.orgCode = orgCode;
    }
    
    public void setRssbNumber(String rssbNumber) {
        if (rssbNumber == null || !rssbNumber.matches("\\d{8}")) {
            throw new IllegalArgumentException("RSSB number must be 8 digits");
        }
        this.rssbNumber = rssbNumber;
    }
    
    public void setContactEmail(String contactEmail) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (!Pattern.matches(emailRegex, contactEmail)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.contactEmail = contactEmail;
    }
}