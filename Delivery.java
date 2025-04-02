package gasBooking;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Delivery extends Booking {
    private int customerOtp;
    private String delPersonName;

    public Delivery(String name, String street, String area, String pincode, String mobileNo, int numberOfCylinders) {
        super(name, street, area, pincode, mobileNo, numberOfCylinders);
    }

    public void amountCalc() {
        if (dt_1 != null && dt_2 != null) {
            long dayDiff = dt_2.getTime() - dt_1.getTime();
            long newDiff = TimeUnit.DAYS.convert(dayDiff, TimeUnit.MILLISECONDS);
    
            // Base amount per cylinder
            double baseAmountPerCylinder = 995.0; // Assuming this is the price for one cylinder
            amount = baseAmountPerCylinder * numberOfCylinders; // Calculate total amount based on cylinders
    
            if (newDiff > 7) {
                refund = 43.75 * numberOfCylinders; // Refund per cylinder if applicable
                amount -= refund; // Deduct refund from total amount
            }
        } else {
            System.out.println("Date values are not initialized.");
        }
    }

    public void verifyOtp(Scanner scanner) {
        if ("B".equals(status)) { // Check if status is "B"
            System.out.println("Enter OTP:");
            
            if (scanner.hasNextInt()) {
                customerOtp = scanner.nextInt();
                scanner.nextLine();  // Consume newline
    
                if (customerOtp != otp) {
                    status = "C"; // Cancelled
                    System.out.println("Incorrect OTP. Booking Cancelled.");
                } else {
                    status = "D"; // Delivered
                    System.out.println("OTP Verified. Delivery Confirmed.");
                }
            } else {
                System.out.println("Invalid OTP format.");
                scanner.nextLine();  // Clear invalid input
            }
        } else {
            System.out.println("No booking found!!!");
        }
    }

    public void delPersonDetails(Scanner scanner) {
        System.out.println("\nEnter Delivery Person name:");
        delPersonName = scanner.nextLine();
        System.out.println("Delivery assigned to: " + delPersonName);
    }
}