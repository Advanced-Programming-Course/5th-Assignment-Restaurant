package restaurant;
import java.util.ArrayList;
public class Invoice {
    private static final float tax_rate = 9.4f;
    private int state = -1;
    private Customer customer;
    private ArrayList<Item> items = new ArrayList<>();
    public Invoice(String customerName, Address customerAddress) {
        this.customer = new Customer(customerName, customerAddress);
    }
    public Invoice(Customer c1) {
    }
    public int getState() {
        return this.state;
    }
    public Customer getCustomer() {
        return this.customer;
    }
    public boolean addItem(Item item) {
        if (this.state == -1) {
            this.items.add(item);
            return true;
        }
        return false;
    }
    public boolean removeItem(Item item) {
        if (this.state == -1 && this.items.contains(item)) {
            this.items.remove(item);
            return true;
        }
        return false;
    }
    public void nextStage() {
        this.state++;
    }
    public int getTotalPrice() {
        double total = 0;
        for (Item item : this.items) {
            total += item.getFood().getPrice() * item.getCount();
        }
        total += total * tax_rate / 100;
        return (int) Math.ceil(total);
    }
    public ArrayList<Item> getItems() {
        return this.items;
    }
}

