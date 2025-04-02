package Customers;

import gasSupplier.gasAgency;

public class Customer implements gasAgency {
    public String name;  // Changed to public
    public String street;  // Changed to public
    public String area;  // Changed to public
    public String pincode;  // Changed to public
    public String mobileNo;  // Changed to public

    // Constructor
    public Customer(String name, String street, String area, String pincode, String mobileNo) {
        this.name = name;
        this.street = street;
        this.area = area;
        this.pincode = pincode;
        this.mobileNo = mobileNo;
    }
}