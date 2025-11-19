package Januario_Henrique.27528.q4;

import java.util.Date;

public class Delivery extends PurchaseOrder {
    private Date deliveryDate;
    private String deliveredBy;
    
    public Delivery(int id, Date createdDate, Date updatedDate,
                   String orgName, String address, String contactEmail,
                   String deptName, String deptCode,
                   String supplierName, String supplierTIN, String contact,
                   String productName, double unitPrice, int quantity,
                   String poNumber, Date orderDate, double totalAmount,
                   Date deliveryDate, String deliveredBy) {
        super(id, createdDate, updatedDate, orgName, address, contactEmail,
              deptName, deptCode, supplierName, supplierTIN, contact,
              productName, unitPrice, quantity, poNumber, orderDate, totalAmount);
        
        if (deliveryDate == null) {
            throw new IllegalArgumentException("Delivery date cannot be null");
        }
        if (deliveredBy == null || deliveredBy.trim().isEmpty()) {
            throw new IllegalArgumentException("Delivered by cannot be empty");
        }
        
        this.deliveryDate = deliveryDate;
        this.deliveredBy = deliveredBy;
    }
    
    public Date getDeliveryDate() { return deliveryDate; }
    public String getDeliveredBy() { return deliveredBy; }
    
    public void setDeliveryDate(Date deliveryDate) {
        if (deliveryDate == null) {
            throw new IllegalArgumentException("Delivery date cannot be null");
        }
        this.deliveryDate = deliveryDate;
    }
    
    public void setDeliveredBy(String deliveredBy) {
        if (deliveredBy == null || deliveredBy.trim().isEmpty()) {
            throw new IllegalArgumentException("Delivered by cannot be empty");
        }
        this.deliveredBy = deliveredBy;
    }
    
    public long getDeliveryDays() {
        long diff = deliveryDate.getTime() - getOrderDate().getTime();
        return diff / (1000 * 60 * 60 * 24); // Convert to days
    }
}