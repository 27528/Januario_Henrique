package Januario_Henrique.27528.q3;

import java.util.Date;

public class Taxpayer extends TaxCategory {
    private String tin;
    private String taxpayerName;
    private String address;
    
    public Taxpayer(int id, Date createdDate, Date updatedDate,
                   String authorityName, String region, String email,
                   String categoryName, double rate, String code,
                   String tin, String taxpayerName, String address) {
        super(id, createdDate, updatedDate, authorityName, region, email,
              categoryName, rate, code);
        
        if (tin == null || !tin.matches("\\d{9}")) {
            throw new IllegalArgumentException("TIN must be 9 digits");
        }
        if (taxpayerName == null || taxpayerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Taxpayer name cannot be empty");
        }
        
        this.tin = tin;
        this.taxpayerName = taxpayerName;
        this.address = address;
    }
    
    public String getTin() { return tin; }
    public String getTaxpayerName() { return taxpayerName; }
    public String getAddress() { return address; }
    
    public void setTin(String tin) {
        if (tin == null || !tin.matches("\\d{9}")) {
            throw new IllegalArgumentException("TIN must be 9 digits");
        }
        this.tin = tin;
    }
    
    public void setTaxpayerName(String taxpayerName) {
        if (taxpayerName == null || taxpayerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Taxpayer name cannot be empty");
        }
        this.taxpayerName = taxpayerName;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
}