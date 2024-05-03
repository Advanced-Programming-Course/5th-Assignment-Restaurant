import java.util.Vector;
class Invoice {
    private static final float taxRate = 0.094f;
    private Customer customer;
    private int state;
    private Vector<Item> items;
    private int price;
    private Item item;

    public Invoice(Customer customer) {
        this.customer = customer;
        this.state = -1;
        this.items = new Vector<>();
    }
    public int getState(){
        return state;
    }
    public Customer getCustomer(){
        return customer;
    }
    public Vector<Item> getItems(){
        return items;
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
            return items.remove(item);
        }
        return false;
    }
    public void nextStage() {
        if (state < 2) {
            state++;
        }
    }
    public int getTotalPrice() {
        double total = 0.0;
        for (Item item : items) {
            total += (item.getFood().getPrice()) * item.getCount();
        }
        double totalTax = total * taxRate;
        return (int) Math.ceil(total + totalTax);
    }
}