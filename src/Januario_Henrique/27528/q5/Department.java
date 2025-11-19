package Januario_Henrique.27528.q5;

import java.util.Date;

public class Department extends Institution {
    private String departmentName;
    private String departmentHead;
    
    public Department(int id, Date createdDate, Date updatedDate,
                     String institutionName, String code, String address,
                     String departmentName, String departmentHead) {
        super(id, createdDate, updatedDate, institutionName, code, address);
        
        if (departmentName == null || departmentName.trim().isEmpty()) {
            throw new IllegalArgumentException("Department name cannot be empty");
        }
        if (departmentHead == null || departmentHead.trim().isEmpty()) {
            throw new IllegalArgumentException("Department head cannot be empty");
        }
        
        this.departmentName = departmentName;
        this.departmentHead = departmentHead;
    }
    
    public String getDepartmentName() { return departmentName; }
    public String getDepartmentHead() { return departmentHead; }
    
    public void setDepartmentName(String departmentName) {
        if (departmentName == null || departmentName.trim().isEmpty()) {
            throw new IllegalArgumentException("Department name cannot be empty");
        }
        this.departmentName = departmentName;
    }
    
    public void setDepartmentHead(String departmentHead) {
        if (departmentHead == null || departmentHead.trim().isEmpty()) {
            throw new IllegalArgumentException("Department head cannot be empty");
        }
        this.departmentHead = departmentHead;
    }
}
