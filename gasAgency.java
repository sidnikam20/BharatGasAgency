package gasSupplier;

public interface gasAgency {
    String agencyName = "Bharat Gas";
    int agencyCode = 1234;
    int phoneNumber = 94205;

    default void agencyDisplay() {
        System.out.println("The Agency name is: " + agencyName);
        System.out.println("Agency code is: " + agencyCode);
        System.out.println("Agency phone no. is: " + phoneNumber);
    }
}