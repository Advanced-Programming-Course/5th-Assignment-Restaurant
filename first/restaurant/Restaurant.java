package restaurant;
public class Restaurant {
    public static void main(String[] args) {
        Address a1 = new Address(2, 3, "Lahijan");
        Address a2 = new Address(5, 6, "Tehran");
    
        System.out.println("\n--------------------------------------\n");
        System.out.println("Distance From Address a1 to a2 is: " + a1.distance_from(a2));
        System.out.println("\n--------------------------------------\n");
    
        Customer c1 = new Customer("MAMAD", a1);
        Customer c2 = new Customer("ALI", a2);
    
        System.out.println("First Customer's ID: " + c1.getCustomerNumber());
        System.out.println("Second Customer's ID: " + c2.getCustomerNumber());
    
        Food f1 = new Food("BURGER", 130);
        Food f2 = new Food("PIZZA", 200);
        Food f3 = new Food("PASTA", 110);
    
        System.out.println("\n--------------------------------------\n");
    
        for (int i = 0; i < Food.getMenu().size(); i++) {
            System.out.println("Food Name: " + Food.getMenu().get(i).getName());
        }
    
        System.out.println("\n--------------------------------------\n");
    
        Item it1 = new Item(f1, 2);
        Item it2 = new Item(f2, 3, "MORE SAUCE");
        Item it3 = new Item(f3, 1);
    
        Invoice inv = new Invoice(c1);
    
        if (inv.addItem(it1) && inv.addItem(it2)) System.out.println("Items added successfully");
        else System.out.println("Items could not be added");
    
        if (inv.removeItem(it3)) System.out.println("Item removed successfully");
        else System.out.println("Failed to remove item (item doesn't exist in invoice)");
    
        inv.nextStage();
    
        System.out.println("Current state: " + inv.getState());
    
        System.out.println("\n--------------------------------------\n");
    
        for (int i = 0; i < inv.getItems().size(); i++) {
            Item it = inv.getItems().get(i);
            System.out.println("Food Name: " + it.getFood().getName() + " | Food Description: " + it.getDescription());
        }
    
        System.out.println("Total price: " + inv.getTotalPrice());
    }


}
