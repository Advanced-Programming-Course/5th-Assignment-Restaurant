import java.util.Vector;

class Invoice {
    private static final float taxRate = 9.4;
    private Customer customer;
    private boolean acceptingOrder;
    private Vector<Item> items;

    public Invoice(Customer customer) {
        this.customer = customer;
        this.acceptingOrder = true;
        this.items = new Vector<Item>();
    }

    public boolean addItem(Item item) {
        if (acceptingOrder) {
            items.add(item);
        }
        return acceptingOrder;
    }

    public boolean removeItem(Item item) {
        if (acceptingOrder) {
            return items.remove(item);
        }
        return false;
    }

    public void nextStage() {
        this.acceptingOrder = false
    }

    public int getState() {
        return state;
    }

    public int getTotalPrice() {
        double total = 0;
        for (Item item : items) {
            total += item.getFood().getPrice() * item.getCount();
        }
        return (int) (total * (taxRate + 100) / 100);
    }

    public Customer getCustomer() {
        return customer;
    }

    public Vector<Item> getItems() {
        return items;
    }
}
