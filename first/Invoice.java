import java.util.ArrayList;

public class Invoice {
    private static final float tax_rate = 0.094f;
    private int state = -1;
    private Customer customer;
    private ArrayList<Item> items = new ArrayList<>();

    public Invoice(Customer customer) {
        this.customer = customer;
    }

    public boolean addItem(Item item) {
        if (state != -1)
            return false;
        items.add(item);
        return true;
    }

    public boolean removeItem(Item item) {
        if (state != -1)
            return false;
        return items.remove(item);
    }

    public void nextStage() {
        state++;
    }

    public int getState() {
        return state;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public int getTotalPrice() {
        double total = 0;
        for (Item item : items) {
            total += item.getFood().getPrice() * item.getCount();
        }
        total += total * tax_rate;
        return (int) Math.ceil(total);
    }

}
