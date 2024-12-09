import java.util.ArrayList;
import java.util.List;
public class Invoice{
    private int state;
    private Customer customer;
    private List<Item> items;
    private static final double tax_rate = 0.094;
    
    public Invoice(Customer customer){
        this.customer = customer;
        this.state = -1;
        this.items=new ArrayList<>();
    }
     public int getState(){
            return this.state;
        }
        public Customer getCustomer(){
            return this.customer;
        }
    public boolean addItem(Item item){
        if (this.state == -1){
            items.add(item);
            return true;
        }
        else{
            return false;}
    }
    public boolean removeItem(Item item){
        if (this.state== -1 && items.contains(item)){
            items.remove(item);
            return true;
        }
        else{
            return false;}
        }
        public void nextStage(){
            this.state= state+1;
        }
        public int getTotalPrice(){
            double total =0 ; 
            for(Item item : items){
                total += item.getFood().getPrice() * item.getCount();
            }
            total += total * tax_rate;
            return (int) Math.ceil(total);
        }
        public List<Item> getItems(){
            return items;
        } 
       
    }
    
