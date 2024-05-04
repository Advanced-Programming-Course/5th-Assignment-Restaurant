package first;
import java.util.ArrayList;
import java.util.List;
public class Invoice {
    private final Customer customer;
    private final List<Item> items;
    private int state;
    private static final float TAX_RATE = 9.4f;
    public List<Item> getItems() {
        return items;
    }
    public Invoice(Customer customer) {
        this.customer = customer;
        this.items = new ArrayList<>();
        this.state = -1;
    }
    public boolean addItem(Item item) {
        if (state == -1) {
            items.add(item);
            return true;
        }
        return false;
    }
    public boolean removeItem(Item item) {
        if (state == -1 && items.contains(item)) {
            items.remove(item);
            return true;
        }
        return false;
    }
    public void nextStage() {
        state++;
    }
    public int getTotalPrice() {
        int totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getFood().getPrice() * item.getCount();
        }
        float tax = totalPrice * TAX_RATE / 100;
        return (int) Math.ceil(totalPrice + tax);
    }
    public Customer getCustomer() {
        return customer;
    }
    public int getState() {
        return state;
    }
}
