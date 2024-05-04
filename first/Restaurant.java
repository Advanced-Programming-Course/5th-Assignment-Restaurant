package first;
public class Restaurant {
    public static void main(String[] args) {

        Address address1 = new Address(35.7219, 51.3347, "Tehran, Iran");
        Address address2 = new Address(35.652832, 139.839478, "Tokyo, Japan");

        Customer customer1 = new Customer("Mahdi", address1);
        Customer customer2 = new Customer("Haruto", address1);

        Food food1 = new Food("Tahchin", 15);
        Food food2 = new Food("Sushi", 25);


        Item item1 = new Item(food1, 2, "Extra barberry");
        Item item2 = new Item(food2, 3, "soy sauce");



        Invoice invoice1 = new Invoice(customer1);
        invoice1.addItem(item1);
        invoice1.addItem(item2);


        System.out.println("\n--------------------------------------\n");
        System.out.println("Distance From Address address1 to address2 is: " + address1.distanceFrom(address2));
        System.out.println("\n--------------------------------------\n");
        System.out.println("First Customer's ID: " + customer1.getCustomerNumber());
        System.out.println("Second Customer's ID: " + customer2.getCustomerNumber());
        System.out.println("\n--------------------------------------\n");

        for (int i = 0; i < Food.getMenu().size(); i++) {
            System.out.println("Food Name: " + Food.getMenu().get(i).getName());
        }

        System.out.println("\n--------------------------------------\n");
        if (invoice1.addItem(item1) && invoice1.addItem(item2)) System.out.println("Items added successfully");
        else System.out.println("Items could not be added");


        invoice1.nextStage();

        System.out.println("Current state: " + invoice1.getState());

        System.out.println("\n--------------------------------------\n");

        for (int i = 0; i < invoice1.getItems().size(); i++) {
            Item items = invoice1.getItems().get(i);
            System.out.println("Food Name: " + items.getFood().getName() + " | Food Description: " + items.getDescription());
        }
        System.out.println("Total price: " + invoice1.getTotalPrice());
    }

}