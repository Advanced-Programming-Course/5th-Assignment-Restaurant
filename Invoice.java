import java.util.Vector;

class Invoice {
    private static final float tax_rate = 9.4f;
    private int state;
    private Customer customer;
    private Vector<Item> items;

    public Invoice(Customer customer) {
        this.state = -1;
        this.customer = customer;
        this.items = new Vector<>();
    }

    public int getState() {
        return state;
    }

    public Customer getCustomer() {
        return customer;
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

    public Vector<Item> getItems() {
        return items;
    }

    public int getTotalPrice() {
        int totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getFood().getPrice() * item.getCount();
        }

        float taxAmount = (totalPrice * tax_rate) / 100;

        int totalPriceWithTax = Math.round(totalPrice + taxAmount);
        return totalPriceWithTax;
    }
}
