package gasBooking;

import Customers.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Booking extends GasConnection {

    public double otp = 5678, amount = 995.0, refund = 0;
    public String dt, delDate, Status, DelMobileNo = "9420993474", status;
    public Date dt_1, dt_2;

    // Constructor
    public Booking(String name, String street, String area, String pincode, String mobile_no, int numberOfCylinders) {
        super(name, street, area, pincode, mobile_no, numberOfCylinders);
    }

    public void getDates(Scanner scanner) {
        System.out.println("Enter Booking Date (dd/MM/yyyy):");
        dt = scanner.nextLine();
        dt_1 = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        // For booking date
        try {
            dt_1 = dateFormat.parse(dt);
        } catch (Exception e) {
            System.out.println("Error parsing booking date: " + e);
        }

        // Delivery details
        System.out.println("Enter Delivery Date (dd/MM/yyyy):");
        delDate = scanner.nextLine();

        try {
            dt_2 = dateFormat.parse(delDate);
        } catch (Exception exp) {
            System.out.println("Error parsing delivery date: " + exp);
        }

        // Find the difference between two dates
        try {
            long difference = dt_2.getTime() - dt_1.getTime();
            long newDifference = TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
            if (newDifference > 7) {
                status = "P";  // Pending status
            }
        } catch (Exception e) {
            System.out.println("Error while finding difference: " + e);
        }
    }
    public void validate(Scanner scanner) {
        if (lastDate == null) {
            System.out.println("Please enter the last booking date:");
            String lastDateInput = scanner.nextLine();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            try {
                lastDate = dateFormat.parse(lastDateInput);
            } catch (Exception e) {
                System.out.println("Error parsing last booking date: " + e);
                return; // Exit the method if parsing fails
            }
        }
    
        long elapsed = dt_1.getTime() - lastDate.getTime();
        long diff = TimeUnit.DAYS.convert(elapsed, TimeUnit.MILLISECONDS);
    
        System.out.println("Difference between two days is: " + diff);
    
        if (numberOfCylinders == 1) {
            if (diff < 30) {
                System.out.println("Booking cannot be done");
                status = "C"; // Cancelled
            } else {
                status = "B";  // Booked
                lastDate = dt_1;
            }
        } else if (numberOfCylinders == 2) {
            if (diff < 50) {
                System.out.println("Booking cannot be done");
                status = "C"; // Cancelled
            } else {
                System.out.println("Booking Done");
                status = "B";  // Booked
                lastDate = dt_1;
            }
        }
    }
}