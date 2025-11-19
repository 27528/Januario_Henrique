package Januario_Henrique.27528.q2;

import java.util.Date;
import java.text.SimpleDateFormat;

public final class Ticket extends Payment {
    private static final String STUDENT_ID = "27528";
    
    private String ticketNumber;
    private Date issueDate;
    
    public Ticket(int id, Date createdDate, Date updatedDate,
                  String airportName, String code, String location,
                  String airlineName, String airlineCode, String contactEmail,
                  String flightNumber, String departure, String destination, double baseFare,
                  String pilotName, String licenseNumber, int experienceYears,
                  String crewName, String role, String shift,
                  String passengerName, int age, String gender, String contact,
                  Date bookingDate, String seatNumber, String travelClass,
                  Date paymentDate, String paymentMethod, double amountPaid,
                  String ticketNumber, Date issueDate) {
        super(id, createdDate, updatedDate, airportName, code, location,
              airlineName, airlineCode, contactEmail, flightNumber, departure, destination, baseFare,
              pilotName, licenseNumber, experienceYears, crewName, role, shift,
              passengerName, age, gender, contact, bookingDate, seatNumber, travelClass,
              paymentDate, paymentMethod, amountPaid);
        
        this.ticketNumber = ticketNumber;
        this.issueDate = issueDate;
    }
    
    public String getTicketNumber() { return ticketNumber; }
    public Date getIssueDate() { return issueDate; }
    
    public void setTicketNumber(String ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
    
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }
    
    public void calculateFare() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        
        StringBuilder output = new StringBuilder();
        
        // STUDENT ID CONCATENATION AT BEGINNING
        output.append("STUDENT ID: ").append(STUDENT_ID).append("\n");
        output.append("╔══════════════════════════════════════════════╗\n");
        output.append("║           FLIGHT BOOKING SYSTEM              ║\n");
        output.append("╚══════════════════════════════════════════════╝\n\n");
        
        double baseFare = getBaseFare();
        double taxes = calculateTaxes(baseFare);
        double discounts = calculateDiscounts();
        double totalFare = (baseFare * getClassMultiplier()) + taxes - discounts;
        
        output.append("=== FARE CALCULATION DETAILS ===\n");
        output.append("Ticket Number: ").append(ticketNumber).append("\n");
        output.append("Passenger: ").append(getPassengerName()).append("\n");
        output.append("Flight: ").append(getFlightNumber()).append(" | ").append(getDeparture());
        output.append(" → ").append(getDestination()).append("\n");
        output.append("Travel Class: ").append(getTravelClass()).append("\n");
        output.append("Seat: ").append(getSeatNumber()).append("\n\n");
        
        output.append("--- Fare Breakdown ---\n");
        output.append(String.format("Base Fare:        $%.2f\n", baseFare));
        output.append(String.format("Class Multiplier: x%.1f\n", getClassMultiplier()));
        output.append(String.format("Adjusted Base:    $%.2f\n", baseFare * getClassMultiplier()));
        output.append(String.format("Taxes & Fees:     $%.2f\n", taxes));
        output.append(String.format("Discounts:       -$%.2f\n", discounts));
        output.append("─────────────────────────────────\n");
        output.append(String.format("TOTAL FARE:       $%.2f\n\n", totalFare));
        
        output.append("--- Passenger Details ---\n");
        output.append("Age: ").append(getAge()).append(" years");
        if (isChild()) output.append(" (Child)");
        if (isSenior()) output.append(" (Senior)");
        output.append("\n");
        output.append("Contact: ").append(getContact()).append("\n\n");
        
        output.append("--- Flight Details ---\n");
        output.append("Airline: ").append(getAirlineName()).append(" (").append(getAirlineCode()).append(")\n");
        output.append("Departure Airport: ").append(getAirportName()).append(" (").append(getCode()).append(")\n");
        output.append("Pilot: ").append(getPilotName());
        if (isSeniorPilot()) output.append(" (Senior Pilot)");
        output.append("\n");
        output.append("Cabin Crew: ").append(getCrewName()).append(" - ").append(getRole());
        if (isSeniorCrew()) output.append(" (Senior Crew)");
        output.append("\n\n");
        
        output.append("--- Payment Information ---\n");
        output.append("Payment Method: ").append(getPaymentMethod()).append("\n");
        output.append("Amount Paid: $").append(String.format("%.2f", getAmountPaid())).append("\n");
        output.append("Payment Status: ").append(isPaymentComplete(totalFare) ? "COMPLETE" : "PENDING").append("\n\n");
        
        output.append("Ticket Issue Date: ").append(dateFormat.format(issueDate)).append("\n");
        output.append("System Created: ").append(dateFormat.format(getCreatedDate())).append("\n");
        
        System.out.println(output.toString());
        saveTicketToFile(output.toString());
    }
    
    private double calculateTaxes(double baseFare) {
        double taxRate = 0.10;
        double fixedFees = 45.00;
        return (baseFare * getClassMultiplier() * taxRate) + fixedFees;
    }
    
    private double calculateDiscounts() {
        double discount = 0.0;
        
        if (isChild()) {
            discount += getBaseFare() * getClassMultiplier() * 0.25;
        }
        
        if (isSenior()) {
            discount += getBaseFare() * getClassMultiplier() * 0.15;
        }
        
        long daysUntilFlight = (getBookingDate().getTime() - new Date().getTime()) / (1000 * 60 * 60 * 24);
        if (daysUntilFlight > 30) {
            discount += getBaseFare() * getClassMultiplier() * 0.10;
        }
        
        return discount;
    }
    
    private void saveTicketToFile(String content) {
        String filename = STUDENT_ID + "_flight_ticket.txt";
        try (java.io.PrintWriter writer = new java.io.PrintWriter(filename)) {
            writer.println(content);
            System.out.println("Ticket saved as: " + filename);
        } catch (java.io.FileNotFoundException e) {
            System.err.println("Error saving ticket: " + e.getMessage());
        }
    }
    
    public double calculateFare(boolean detailed) {
        if (!detailed) {
            double baseFare = getBaseFare() * getClassMultiplier();
            double taxes = calculateTaxes(getBaseFare());
            double discounts = calculateDiscounts();
            return baseFare + taxes - discounts;
        }
        calculateFare();
        return 0.0;
    }
}