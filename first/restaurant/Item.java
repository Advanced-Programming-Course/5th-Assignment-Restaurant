package restaurant;
public class Item {
    private final Food food;
    private final int count;
    private String description = "";
    public Item(Food food, int count) {
        this.food = food;
        this.count = count;
    }
    public Item(Food food, int count , String desc) {
        this.food = food;
        this.count = count;
        this.description = desc;
    }
    public Food getFood() {
        return this.food;
    }
    public int getCount() {
        return this.count;
    }
    public String getDescription() {
        return this.description;
    }
}
