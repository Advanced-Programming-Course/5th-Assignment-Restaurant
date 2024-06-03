import java.util.Vector;

public class Food {
    private static Vector<Food> menu = new Vector<>();
    private final String name;
    private final int price;

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
}
