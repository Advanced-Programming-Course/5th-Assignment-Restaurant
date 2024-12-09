package restaurant;
public class Customer {
    private static int nId = 1;
    private Address address;
    private String name;
    private final int cuNum;
    public Customer(String name, Address address) {
        this.cuNum = nId++;
        this.name = name;
        this.address = address;
    }
    public int getCustomerNumber() {
        return this.cuNum;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Address getAddress() {
        return this.address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
}
