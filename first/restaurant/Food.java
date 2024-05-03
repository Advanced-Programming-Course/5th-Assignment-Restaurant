import java.util.Vector;

public class Food {

    private Vector<Food> menu = new Vector<>();
    private final String name;
    private final int price;

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
}