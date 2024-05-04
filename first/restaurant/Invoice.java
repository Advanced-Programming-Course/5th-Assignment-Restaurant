import java.util.Vector;

public class Invoice {

    private static final float tax_rate = 0.094f;
    private int state;
    private final Customer customer;
    private final Vector<Item> items;
    private float totalPrice;

    public Invoice(Customer customer) {
        this.state = -1;
        this.customer = customer;
        this.items = new Vector<>();
        this.totalPrice = 0.0f;
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
            calculateTotalPrice();
            return true;
        }
        else {
            return false;
        }
    }

    public boolean removeItem(Item item) {
        int i = 0;
        if (state == -1) {
            for (Item currItem : items) {
                if (currItem.getFood().equals(item.getFood())) {
                    items.remove(i);
                    calculateTotalPrice();
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    public void nextStage() {
        state++;

    }

    public Vector<Item> getItems() {
        return items;
    }

    public int getTotalPrice() {
        return (int) Math.ceil(totalPrice);
    }

    private void calculateTotalPrice() {
        totalPrice = 0.0f;
        for (Item item : items) {
            // add up all prices
            totalPrice += item.getCount() * item.getFood().getPrice();
        }
        // totalprice + calculated tax
        totalPrice += totalPrice * tax_rate;

    }
}