public class Customer {
    private static int objCounter = 0;
    private int customerNumber;
    private String name;
    private Address a;
    public Customer(String name, Address a) {
        objCounter++;
        setName(name);
        setCustomerNumber(objCounter);
        setAddress(a);
    }
    private void setCustomerNumber(int objCounter) {
        customerNumber = objCounter;
    }
    public void setAddress(Address a) {
        this.a = a;
    }
    public void getAddress() {
        System.out.println("latitude is: " + a.latitude + " & longtitude is: " + a.longtitude + " in " + a.written_address);
    }
    public int getCustomerNumber() {
        return customerNumber;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
