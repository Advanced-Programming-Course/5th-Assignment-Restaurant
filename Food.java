import java.util.Vector;

public class Food {
    private static Vector<Food> menu = new Vector<>();
    private String name;
    public int price;

    public Food(String name, int price) {
        this.name = name;
        this.price = price;
        menu.add(this);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public static Vector<Food> getMenu() {
        return menu;
    }
}
