package restaurant;

import java.util.ArrayList;
import java.util.List;

public class Food {
    private static List<Food> menu = new ArrayList<>();
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

    public static List<Food> getMenu() {
        return menu;
    }
}
