package Januario_Henrique.27528.q3;

import java.util.Date;
import java.util.regex.Pattern;

public class TaxAuthority extends Entity {
    private String authorityName;
    private String region;
    private String email;
    
    public TaxAuthority(int id, Date createdDate, Date updatedDate,
                       String authorityName, String region, String email) {
        super(id, createdDate, updatedDate);
        
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (!Pattern.matches(emailRegex, email)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        
        this.authorityName = authorityName;
        this.region = region;
        this.email = email;
    }
    
    public String getAuthorityName() { return authorityName; }
    public String getRegion() { return region; }
    public String getEmail() { return email; }
    
    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }
    
    public void setRegion(String region) {
        this.region = region;
    }
    
    public void setEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (!Pattern.matches(emailRegex, email)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.email = email;
    }
}
