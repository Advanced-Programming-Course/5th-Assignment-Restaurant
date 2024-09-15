
public class Customer {
    private static int nextId = 1;
    private final int id;
    private String name; // نام مشتری
    private Address address; // آدرس مشتری

    public Customer(String name, Address address) {
        this.id = nextId++;
        this.name = name;
        this.address = address;
    }

    public int getCustomerNumber() {
        return id;
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

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + id +
                ", name='" + name +
                "', address=" + address +
                '}';
    }
}
