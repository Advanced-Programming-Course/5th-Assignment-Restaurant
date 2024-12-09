import java.util.ArrayList;

public class Invoice {
    private static final float tax_rate = 9.4f;
    private static final int ORDER_REGISTERED = -1;
    private static final int ORDER_PREPARING = 0;
    private static final int ORDER_DISPATCHED = 1;
    private static final int ORDER_DELIVERED = 2;

    private final Customer customer;
    private final ArrayList<Item> items;
    private int state;

    public Invoice(Customer customer) {
        this.customer = customer;
        this.items = new ArrayList<>();
        this.state = ORDER_REGISTERED;
    }

    public boolean addItem(Item item) {
        if (state != ORDER_REGISTERED || !items.contains(item)) {
            return false;
        }
        items.add(item);
        return true;
    }

    public boolean removeItem(Item item) {
        if (items.contains(item)) {
            items.remove(item);
            return true;
        }
        return false;
    }

    public void nextStage() {
        if (state < ORDER_DELIVERED) {
            state++;
        }
    }

    public int getState() {
        return state;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getFood().getPrice() * item.getCount();
        }
        float taxAmount = (totalPrice * tax_rate) / 100;
        return (int) Math.ceil(totalPrice + taxAmount);
    }
}
