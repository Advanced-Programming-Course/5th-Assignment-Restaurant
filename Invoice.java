import java.util.ArrayList;

public class Invoice {
    private int state;
    private Customer customer;
    private ArrayList<Item> items;
    public Invoice(Customer customer) {
        setCustomer(customer);
        setState(-1);
        setItems();
    }
    private void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public Customer getCustomer() {
        return customer;
    }
    private void setState(int state) {
        this.state = state;
    }
    public int getState() {
        return state;
    }
    private void setItems() {
        this.items = new ArrayList<>();
    }
    public ArrayList<Item> getItems() {
        return items;
    }
    public boolean addItem(Item item) {
        if(state == -1) {
            items.add(item);
            return true;
        }
        return false;
    }
    public boolean removeItem(Item item){
        if(state == -1){
            items.remove(item);
            return true;
        }
        return false;
    }
    public void nextStage() {
        if(state < 2) {
            state++;
        }
    }
    public int getTotalPrice() {
        int totalPrice = 0;
        for(Item item : items) {
            totalPrice += (item.getCount() * item.getFood().getPrice());
        }
        double totalTax = ((totalPrice * 9.4) / 100);
        return (int)Math.ceil(totalPrice + totalTax);
    }
}

