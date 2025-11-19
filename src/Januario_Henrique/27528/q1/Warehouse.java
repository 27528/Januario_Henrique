package Januario_Henrique.27528.q1;

import java.util.Date;

public class Warehouse extends Entity {
    private String warehouseName;
    private String location;
    private String contactNumber;
    
    public Warehouse(int id, Date createdDate, Date updatedDate,
                    String warehouseName, String location, String contactNumber) {
        super(id, createdDate, updatedDate);
        
        if (!contactNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must be 10 digits");
        }
        
        this.warehouseName = warehouseName;
        this.location = location;
        this.contactNumber = contactNumber;
    }
    
    public String getWarehouseName() { return warehouseName; }
    public String getLocation() { return location; }
    public String getContactNumber() { return contactNumber; }
    
    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public void setContactNumber(String contactNumber) {
        if (!contactNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone number must be 10 digits");
        }
        this.contactNumber = contactNumber;
    }
}