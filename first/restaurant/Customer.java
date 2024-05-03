public class Customer {
    private static int newId = 1;
    private final int id;
    private String name;
    private Address address;

    public Customer(String name, Address address) {
        this.id = newId;
        newId++;
        this.name = name;
        this.address = address;
    }

    public int getCustomerNumber() {
        return id;
    }

    // no set for customer number as it is final

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