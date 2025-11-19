package Januario_Henrique.27528.q5;

import java.util.Date;

public class AttendanceRecord extends ClassSession {
    private String studentID;
    private String sessionID;
    private String status;
    
    public AttendanceRecord(int id, Date createdDate, Date updatedDate,
                           String institutionName, String code, String address,
                           String departmentName, String departmentHead,
                           String courseName, String courseCode, int credits,
                           String instructorName, String email, String phone,
                           String studentName, String studentID, int age,
                           Date sessionDate, String topic,
                           String attendanceStudentID, String sessionID, String status) {
        super(id, createdDate, updatedDate, institutionName, code, address,
              departmentName, departmentHead, courseName, courseCode, credits,
              instructorName, email, phone, studentName, studentID, age,
              sessionDate, topic);
        
        if (!status.equals("Present") && !status.equals("Absent")) {
            throw new IllegalArgumentException("Status must be 'Present' or 'Absent'");
        }
        
        this.studentID = attendanceStudentID;
        this.sessionID = sessionID;
        this.status = status;
    }
    
    public String getStudentID() { return studentID; }
    public String getSessionID() { return sessionID; }
    public String getStatus() { return status; }
    
    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }
    
    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }
    
    public void setStatus(String status) {
        if (!status.equals("Present") && !status.equals("Absent")) {
            throw new IllegalArgumentException("Status must be 'Present' or 'Absent'");
        }
        this.status = status;
    }
    
    public boolean isPresent() {
        return status.equals("Present");
    }
}
