package Customers;

import java.text.SimpleDateFormat;
import java.util.*;

public class GasConnection extends Customer {
    public int numberOfCylinders;  // Changed to public
    protected Date lastDate = null;
    static int connectionNumber = 100;
    String date;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    // Constructor
    public GasConnection(String name, String street, String area, String pincode, String mobileNo, int numberOfCylinders) {
        super(name, street, area, pincode, mobileNo);
        this.numberOfCylinders = numberOfCylinders;
        connectionNumber += 1;
    }

    public void getLastDate() {
        System.out.println("Enter the last date please:");
        Scanner scanner = new Scanner(System.in);
        date = scanner.nextLine();
        try {
            lastDate = dateFormat.parse(date);
        } catch (Exception e) {
            System.out.println("Error in get Last date:" + e);
        } finally {
            scanner.close();
        }
    }
}