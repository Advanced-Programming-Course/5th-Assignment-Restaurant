import java.util.Vector;

public class Food {

    private final static Vector<Food> menu = new Vector<>(); // لیست غذاها
    private final String name; // نام غذا
    private final int price; // قیمت غذا

    public Food(String name, int price) {
        this.name = name;
        this.price = price;
        menu.add(this);
    }

    public static Vector<Food> getMenu() {
        return menu;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
