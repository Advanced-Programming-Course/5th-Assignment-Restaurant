import java.util.Vector;

public class Food {
    private static Vector<Food> menu = new Vector<>();
    private String name;
    private int price;
    public Food(String name, int price) {
        setName(name);
        setPrice(price);
        menu.add(this);
    }
    private void setName(String name) {
        this.name = name;
    }
    private void setPrice(int price) {
        this.price = price;
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
