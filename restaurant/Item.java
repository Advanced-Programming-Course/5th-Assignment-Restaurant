public class Item {
    private Food food;
    private int count;
    private String description;

    public Item(Food food, int count, String description) {
        this.food = food;
        this.count = count;
        this.description = description;
    }

    public Item(Food food, int count) {
        this.food = food;
        this.count = count;
        this.description = "";
    }

    public Food getFood() {
        return food;
    }

    public int getCount() {
        return count;
    }

    public String getDescription() {
        return description;
    }
}
