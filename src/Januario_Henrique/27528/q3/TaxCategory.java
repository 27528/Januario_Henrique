ppackage Januario_Henrique.27528.q3;

import java.util.Date;

public class TaxCategory extends TaxAuthority {
    private String categoryName;
    private double rate;
    private String code;
    
    public TaxCategory(int id, Date createdDate, Date updatedDate,
                      String authorityName, String region, String email,
                      String categoryName, double rate, String code) {
        super(id, createdDate, updatedDate, authorityName, region, email);
        
        if (rate <= 0) {
            throw new IllegalArgumentException("Tax rate must be greater than 0");
        }
        if (code == null || code.length() < 3) {
            throw new IllegalArgumentException("Tax code must be at least 3 characters");
        }
        
        this.categoryName = categoryName;
        this.rate = rate;
        this.code = code;
    }
    
    public String getCategoryName() { return categoryName; }
    public double getRate() { return rate; }
    public String getCode() { return code; }
    
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    public void setRate(double rate) {
        if (rate <= 0) {
            throw new IllegalArgumentException("Tax rate must be greater than 0");
        }
        this.rate = rate;
    }
    
    public void setCode(String code) {
        if (code == null || code.length() < 3) {
            throw new IllegalArgumentException("Tax code must be at least 3 characters");
        }
        this.code = code;
    }
    
    public double calculateTax(double income) {
        return income * rate;
    }
}
