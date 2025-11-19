package Januario_Henrique.27528.q5;

import java.util.Date;
import java.util.regex.Pattern;

public class Instructor extends Course {
    private String instructorName;
    private String email;
    private String phone;
    
    public Instructor(int id, Date createdDate, Date updatedDate,
                     String institutionName, String code, String address,
                     String departmentName, String departmentHead,
                     String courseName, String courseCode, int credits,
                     String instructorName, String email, String phone) {
        super(id, createdDate, updatedDate, institutionName, code, address,
              departmentName, departmentHead, courseName, courseCode, credits);
        
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (!Pattern.matches(emailRegex, email)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        if (!phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone must be 10 digits");
        }
        
        this.instructorName = instructorName;
        this.email = email;
        this.phone = phone;
    }
    
    public String getInstructorName() { return instructorName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    
    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }
    
    public void setEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        if (!Pattern.matches(emailRegex, email)) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.email = email;
    }
    
    public void setPhone(String phone) {
        if (!phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("Phone must be 10 digits");
        }
        this.phone = phone;
    }
}
