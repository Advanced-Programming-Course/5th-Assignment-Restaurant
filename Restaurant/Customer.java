public class Customer {
    private int customerNumber;
    private String name;
    private Address address;
    public double latitude;
    public double longitude;
    public String writtenAddress;

    public Customer(String name , Address address) {
        this.customerNumber = generateUniqueCustomerNumber();
        this.name = "";
        this.address = new Address(latitude, longitude, writtenAddress);
    }

    private static int nextCustomerNumber = 1;
    private int generateUniqueCustomerNumber() {
        return nextCustomerNumber++;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
}