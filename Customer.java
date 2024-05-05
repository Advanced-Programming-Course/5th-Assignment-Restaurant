public class Customer {
    private int number;
    private String name;
    private Address address;

    public Customer(int number, String name, Address address) {
        this.number = number;
        this.name = name;
        this.address = new Address(latitude, longitude, writtenAddress);
    }

    public int getCustomerNumber() {
        return number;
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
