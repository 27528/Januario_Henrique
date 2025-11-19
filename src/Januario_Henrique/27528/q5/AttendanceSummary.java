package Januario_Henrique.27528.q5;

import java.util.Date;
import java.text.SimpleDateFormat;

public final class AttendanceSummary extends LeaveRequest {
    private static final String STUDENT_ID = "27528";
    
    private Date reportDate;
    private int totalPresent;
    private int totalAbsent;
    
    public AttendanceSummary(int id, Date createdDate, Date updatedDate,
                            String institutionName, String code, String address,
                            String departmentName, String departmentHead,
                            String courseName, String courseCode, int credits,
                            String instructorName, String email, String phone,
                            String studentName, String studentID, int age,
                            Date sessionDate, String topic,
                            String attendanceStudentID, String sessionID, String status,
                            Date requestDate, String reason, boolean approved,
                            Date reportDate, int totalPresent, int totalAbsent) {
        super(id, createdDate, updatedDate, institutionName, code, address,
              departmentName, departmentHead, courseName, courseCode, credits,
              instructorName, email, phone, studentName, studentID, age,
              sessionDate, topic, attendanceStudentID, sessionID, status,
              requestDate, reason, approved);
        
        if (totalPresent < 0) {
            throw new IllegalArgumentException("Total present cannot be negative");
        }
        if (totalAbsent < 0) {
            throw new IllegalArgumentException("Total absent cannot be negative");
        }
        
        this.reportDate = reportDate;
        this.totalPresent = totalPresent;
        this.totalAbsent = totalAbsent;
    }
    
    public Date getReportDate() { return reportDate; }
    public int getTotalPresent() { return totalPresent; }
    public int getTotalAbsent() { return totalAbsent; }
    
    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }
    
    public void setTotalPresent(int totalPresent) {
        if (totalPresent < 0) {
            throw new IllegalArgumentException("Total present cannot be negative");
        }
        this.totalPresent = totalPresent;
    }
    
    public void setTotalAbsent(int totalAbsent) {
        if (totalAbsent < 0) {
            throw new IllegalArgumentException("Total absent cannot be negative");
        }
        this.totalAbsent = totalAbsent;
    }
    
    // FINAL METHOD: generateSummary() = totalPresent / totalSessions × 100
    public void generateSummary() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        StringBuilder output = new StringBuilder();
        
        // STUDENT ID CONCATENATION AT BEGINNING
        output.append("STUDENT ID: ").append(STUDENT_ID).append("\n");
        output.append("╔══════════════════════════════════════════════╗\n");
        output.append("║           ATTENDANCE MANAGEMENT SYSTEM       ║\n");
        output.append("╚══════════════════════════════════════════════╝\n\n");
        
        int totalSessions = totalPresent + totalAbsent;
        double attendancePercentage = totalSessions > 0 ? 
            (double) totalPresent / totalSessions * 100 : 0;
        
        output.append("Report Date: ").append(dateFormat.format(reportDate)).append("\n");
        output.append("Total Sessions: ").append(totalSessions).append("\n\n");
        
        output.append("=== ATTENDANCE SUMMARY ===\n");
        output.append("Total Present: ").append(totalPresent).append("\n");
        output.append("Total Absent: ").append(totalAbsent).append("\n");
        output.append(String.format("Attendance Rate: %.1f%%\n", attendancePercentage));
        output.append("Attendance Status: ").append(getAttendanceStatus(attendancePercentage)).append("\n\n");
        
        output.append("--- Institution Information ---\n");
        output.append("Institution: ").append(getInstitutionName()).append(" (").append(getCode()).append(")\n");
        output.append("Address: ").append(getAddress()).append("\n");
        output.append("Department: ").append(getDepartmentName()).append("\n");
        output.append("Department Head: ").append(getDepartmentHead()).append("\n\n");
        
        output.append("--- Course Details ---\n");
        output.append("Course: ").append(getCourseName()).append(" (").append(getCourseCode()).append(")\n");
        output.append("Credits: ").append(getCredits()).append("\n");
        output.append("Course Level: ").append(isAdvancedCourse() ? "Advanced" : "Basic").append("\n");
        output.append("Instructor: ").append(getInstructorName()).append("\n");
        output.append("Instructor Contact: ").append(getEmail()).append(" | ").append(getPhone()).append("\n\n");
        
        output.append("--- Student Information ---\n");
        output.append("Student: ").append(getStudentName()).append("\n");
        output.append("Student ID: ").append(getStudentID()).append("\n");
        output.append("Age: ").append(getAge()).append(" years (").append(getStudentCategory()).append(")\n\n");
        
        output.append("--- Session Details ---\n");
        output.append("Session Date: ").append(dateFormat.format(getSessionDate())).append("\n");
        output.append("Topic: ").append(getTopic()).append("\n");
        output.append("Session Status: ").append(isSessionCompleted() ? "COMPLETED" : "UPCOMING").append("\n");
        output.append("Attendance Record: ").append(getStatus()).append("\n");
        output.append("Present: ").append(isPresent() ? "YES" : "NO").append("\n\n");
        
        output.append("--- Leave Request ---\n");
        output.append("Request Date: ").append(dateFormat.format(getRequestDate())).append("\n");
        output.append("Reason: ").append(getReason()).append("\n");
        output.append("Approved: ").append(isApproved() ? "YES" : "NO").append("\n");
        output.append("Leave Status: ").append(isLeaveApproved() ? "APPROVED ABSENCE" : "NOT APPROVED").append("\n\n");
        
        output.append("=== PERFORMANCE ANALYSIS ===\n");
        output.append(String.format("Attendance Percentage: %.1f%%\n", attendancePercentage));
        output.append("Minimum Requirement: 75.0%\n");
        output.append("Requirement Met: ").append(attendancePercentage >= 75.0 ? "YES" : "NO").append("\n");
        
        if (totalSessions > 0) {
            output.append("\n--- Detailed Breakdown ---\n");
            output.append(String.format("Present Sessions: %d (%.1f%%)\n", 
                totalPresent, (double) totalPresent / totalSessions * 100));
            output.append(String.format("Absent Sessions: %d (%.1f%%)\n", 
                totalAbsent, (double) totalAbsent / totalSessions * 100));
            
            if (isLeaveApproved()) {
                output.append("Approved Absences: 1 (Included in absent count)\n");
            }
        }
        
        output.append("\n--- Recommendations ---\n");
        if (attendancePercentage < 75.0) {
            output.append("⚠️  ATTENTION: Attendance below minimum requirement!\n");
            output.append("   - Consider improving attendance\n");
            output.append("   - Contact academic advisor if needed\n");
        } else if (attendancePercentage >= 90.0) {
            output.append("✅ EXCELLENT: Attendance is outstanding!\n");
        } else {
            output.append("📊 GOOD: Attendance meets requirements\n");
        }
        
        output.append("\n--- System Information ---\n");
        output.append("Report Generated: ").append(dateFormat.format(reportDate)).append("\n");
        output.append("Record Created: ").append(dateFormat.format(getCreatedDate())).append("\n");
        output.append("Last Updated: ").append(dateFormat.format(getUpdatedDate())).append("\n");
        output.append("==========================================\n");
        
        System.out.println(output.toString());
        saveAttendanceSummary(output.toString());
    }
    
    private String getAttendanceStatus(double percentage) {
        if (percentage >= 90.0) return "Excellent";
        else if (percentage >= 80.0) return "Good";
        else if (percentage >= 75.0) return "Satisfactory";
        else if (percentage >= 60.0) return "Needs Improvement";
        else return "Poor";
    }
    
    private void saveAttendanceSummary(String content) {
        String filename = STUDENT_ID + "_attendance_summary.txt";
        try (java.io.PrintWriter writer = new java.io.PrintWriter(filename)) {
            writer.println(content);
            System.out.println("Attendance summary saved as: " + filename);
        } catch (java.io.FileNotFoundException e) {
            System.err.println("Error saving attendance summary: " + e.getMessage());
        }
    }
    
    // Overloaded method for quick summary
    public double generateSummary(boolean detailed) {
        int totalSessions = totalPresent + totalAbsent;
        double attendancePercentage = totalSessions > 0 ? 
            (double) totalPresent / totalSessions * 100 : 0;
        
        if (!detailed) {
            return attendancePercentage;
        }
        generateSummary();
        return attendancePercentage;
    }
}
