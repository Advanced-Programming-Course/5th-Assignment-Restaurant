import java.util.Vector;
public class Food{
    private final String name;
    private final int price;
    private static Vector<Food> menu= new Vector<>();
    
    public Food(String n , int p){
        this.name=n;
        this.price = p;
        menu.add(this);
        
    }
    public static Vector<Food> getMenu(){
        return menu;
    }
    public int getPrice(){
        return price;
    }
    public String getName(){
        return name;
    }
    
}