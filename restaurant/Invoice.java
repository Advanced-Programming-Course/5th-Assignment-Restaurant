package restaurant;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private static final float TAX_RATE = 0.094f;
    private int state = -1;
    private final Customer customer;
    private final List<Item> items = new ArrayList<>();

    public Invoice(Customer customer) {
        this.customer = customer;
    }

    public int getState() {
        return state;
    }

    public Customer getCustomer() {
        return customer;
    }

    public boolean addItem(Item item) {
        if (state == -1) {
            items.add(item);
            return true;
        }
        return false;
    }

    public boolean removeItem(Item item) {
        if (state == -1) {
            return items.removeIf(i -> i.getFood().equals(item.getFood()));
        }
        return false;
    }

    public void nextStage() {
        if (state < 2) {
            state++;
        }
    }

    public int getTotalPrice() {
        int total = 0;
        for (Item item : items) {
            total += item.getFood().getPrice() * item.getCount();
        }
        total = (int) Math.ceil(total * (1 + TAX_RATE));
        return total;
    }

    public List<Item> getItems() {
        return items;
    }
}
