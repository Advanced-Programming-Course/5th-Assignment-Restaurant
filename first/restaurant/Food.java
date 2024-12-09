package restaurant;
import java.util.Vector;
public class Food {
    private static Vector<Food> menu = new Vector<Food>();
    private final String name;
    private final int price;
    public Food(String name, int price) {
        this.name = name;
        this.price = price;
        menu.add(this);
    }
    public String getName() {
        return this.name;
    }
    public int getPrice() {
        return this.price;
    }
    public static Vector<Food> getMenu() {
        return menu;
    }
}
