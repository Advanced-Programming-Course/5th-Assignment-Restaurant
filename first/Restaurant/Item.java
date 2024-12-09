public class Item {
    private final Food food;
    private final int count;
    private final String description;

    public Item(Food food, int count, String description) {
        this.food = food;
        this.count = count;
        if(description != null) {
            this.description = description;
        } else {
            this.description = "";
        }
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