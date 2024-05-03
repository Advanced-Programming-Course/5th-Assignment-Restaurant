class Customer{

}
class Food{

}
class item{
    private final Food food;
    private final int count;
    private final String description;
    public item(Food food1, int count1, String description1){
        this.food = food1;
        this.count = count1;
        this.description = description1;
    }

    public Food getFood(){
        return food;
    }
    public int getCount(){
        return count;
    }
    public String getDescription(){
        return description;
    }
}

class Invoice{
    private int state;
    private Customer customer;
    public int getState(){
        return state;
    }
    public Invoice(Customer customer1){
        this.customer = customer1;
        this.state = -1;
    }

    public int additem(item item){

    }

}