package Januario_Henrique.27528.q6;

import java.util.Date;

public class Department extends Organization {
    private String deptName;
    private String deptCode;
    private String managerName;
    
    public Department(int id, Date createdDate, Date updatedDate,
                     String orgName, String orgCode, String rssbNumber, String contactEmail,
                     String deptName, String deptCode, String managerName) {
        super(id, createdDate, updatedDate, orgName, orgCode, rssbNumber, contactEmail);
        
        if (deptCode == null || deptCode.length() < 3) {
            throw new IllegalArgumentException("Department code must be at least 3 characters");
        }
        if (deptName == null || deptName.trim().isEmpty()) {
            throw new IllegalArgumentException("Department name cannot be empty");
        }
        if (managerName == null || managerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Manager name cannot be empty");
        }
        
        this.deptName = deptName;
        this.deptCode = deptCode;
        this.managerName = managerName;
    }
    
    public String getDeptName() { return deptName; }
    public String getDeptCode() { return deptCode; }
    public String getManagerName() { return managerName; }
    
    public void setDeptName(String deptName) {
        if (deptName == null || deptName.trim().isEmpty()) {
            throw new IllegalArgumentException("Department name cannot be empty");
        }
        this.deptName = deptName;
    }
    
    public void setDeptCode(String deptCode) {
        if (deptCode == null || deptCode.length() < 3) {
            throw new IllegalArgumentException("Department code must be at least 3 characters");
        }
        this.deptCode = deptCode;
    }
    
    public void setManagerName(String managerName) {
        if (managerName == null || managerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Manager name cannot be empty");
        }
        this.managerName = managerName;
    }
}