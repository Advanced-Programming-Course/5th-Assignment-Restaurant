public class Item{
    private final Food food;
    private final int count;
    private final String description;
    
    public Item(Food food , int count){
        this.count=count;
        this.food=food;
        this.description="-";
    }
    
    public Item(Food food , int count , String d){
        this.count=count;
        this.food=food;
        this.description=d;
    }
    public int getCount(){
        return count;
    }
    public Food getFood(){
        return food;
    }
    public String getDescription(){
        return description;
    }
    
}