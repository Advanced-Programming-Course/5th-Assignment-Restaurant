public class Item {
    private Food food;
    private int count;
    private String description;
    public Item(Food food, int count) {
        setCount(count);
        setFood(food);
        description = "";
    }
    public Item(Food food, int count, String description) {
        setCount(count);
        setFood(food);
        setDescription(description);
    }
    private void setFood(Food food) {
        this.food = food;
    }
    private void setDescription(String description) {
        this.description = description;
    }
    private void setCount(int count) {
        this.count = count;
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
