package gasBooking;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Collect customer details
        System.out.println("Enter customer name:");
        String name = scanner.nextLine();
        
        System.out.println("Enter street:");
        String street = scanner.nextLine();
        
        System.out.println("Enter area:");
        String area = scanner.nextLine();
        
        System.out.println("Enter pincode:");
        String pincode = scanner.nextLine();
        
        System.out.println("Enter mobile number:");
        String mobileNo = scanner.nextLine();
        
        System.out.println("Enter number of cylinders:");
        int numberOfCylinders = scanner.nextInt();
        scanner.nextLine();  // Consume the leftover newline

        // Create a Delivery object
        Delivery delivery = new Delivery(name, street, area, pincode, mobileNo, numberOfCylinders);

        // Menu-driven program
        int choice;
        do {
            System.out.println("\nMENU:");
            System.out.println("1. Calculate Amount");
            System.out.println("2. Verify OTP");
            System.out.println("3. Enter Delivery Person Details");
            System.out.println("4. Display Details");
            System.out.println("5. Exit");
            
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                delivery.getDates(scanner);  // Initialize dates
                delivery.validate(scanner);    // Pass the scanner instance
                delivery.amountCalc();         // Calculate amount
                System.out.println("Amount calculated successfully.");
                System.out.println("Refund (if applicable): ₹" + delivery.refund);
                System.out.println("Final Amount: ₹" + delivery.amount);
    break;

                case 2:
                    delivery.verifyOtp(scanner);
                    System.out.println("Booking Status: " + delivery.status);
                    break;

                case 3:
                    delivery.delPersonDetails(scanner);
                    break;

                case 4:
                    System.out.println("\n--- Booking Details ---");
                    System.out.println("Customer: " + delivery.name);
                    System.out.println("Address: " + delivery.street + ", " + delivery.area + ", " + delivery.pincode);
                    System.out.println("Mobile: " + delivery.mobileNo);
                    System.out.println("Cylinders: " + delivery.numberOfCylinders);
                    System.out.println("Amount: ₹" + delivery.amount);
                    System.out.println("Status: " + delivery.status);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        // Close the scanner
        scanner.close();
    }
}