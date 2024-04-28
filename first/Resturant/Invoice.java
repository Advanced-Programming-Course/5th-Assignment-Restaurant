import java.util.ArrayList;
import java.util.List;

public class Invoice {

    private static final float TAX_RATE = 0.094f; // نرخ مالیات (9.4%)
    private int state;
    private final Customer customer; // مشتری
    private final List<Item> items; // لیست آیتم های فاکتور
    private float totalPrice; // قیمت کل

    public Invoice(Customer customer) {
        this.state = -1;
        this.customer = customer;
        this.items = new ArrayList<>();
        this.totalPrice = 0.0f;
    }

    public int getState() {
        return state;
    }

    public Customer getCustomer() {
        return customer;
    }

    public boolean addItem(Item item) {
        if (state == -1) { // فقط در حال ثبت سفارش
            items.add(item);
            recalculateTotalPrice();
            return true;
        }
        else {
            return false;
        }
    }

    public boolean removeItem(Item item) {
        if (state == -1) { // فقط در حال ثبت سفارش
            for (Item existingItem : items) {
                if (existingItem.getFood().equals(item.getFood())) {
                    items.remove(existingItem);
                    recalculateTotalPrice();
                    return true;
                }
            }
        }
        return false;
    }

    public void nextStage() {
        if (state < 3)
            state++;

    }

    public List<Item> getItems() {
        return items; // لیست آیتم های فاکتور را برمی گرداند
    }

    public int getTotalPrice() {
        return (int)Math.ceil(totalPrice);
    }

    private void recalculateTotalPrice() {
        totalPrice = 0.0f;
        for (Item item : items) {
            totalPrice += item.getCount() * item.getFood().getPrice();
        }
        totalPrice += totalPrice * TAX_RATE;

    }

    @Override
    public String toString() {
        return "Invoice{" +
                "state=" + state +
                ", customer=" + customer +
                ", items=" + items +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
