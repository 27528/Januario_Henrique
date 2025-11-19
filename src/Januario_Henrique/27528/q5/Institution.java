package Januario_Henrique.27528.q5;

import java.util.Date;

public class Institution extends Entity {
    private String institutionName;
    private String code;
    private String address;
    
    public Institution(int id, Date createdDate, Date updatedDate,
                      String institutionName, String code, String address) {
        super(id, createdDate, updatedDate);
        
        if (code == null || code.length() < 3) {
            throw new IllegalArgumentException("Institution code must be at least 3 characters");
        }
        
        this.institutionName = institutionName;
        this.code = code;
        this.address = address;
    }
    
    public String getInstitutionName() { return institutionName; }
    public String getCode() { return code; }
    public String getAddress() { return address; }
    
    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }
    
    public void setCode(String code) {
        if (code == null || code.length() < 3) {
            throw new IllegalArgumentException("Institution code must be at least 3 characters");
        }
        this.code = code;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
}