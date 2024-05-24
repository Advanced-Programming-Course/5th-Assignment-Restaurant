#Address
import java.util.Scanner;

class Address {
    private double latitude;
    private double longitude;
    private String written_address;

    public Address(double latitude, double longitude, String written_address) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.written_address = written_address;
    }

    public double getdistance_from(Address address) {
        double earthRadius = 6371; 
        double lat1 = Math.toRadians(this.latitude);
        double lon1 = Math.toRadians(this.longitude);
        double lat2 = Math.toRadians(address.latitude);
        double lon2 = Math.toRadians(address.longitude);

        double dLat = lat2 - lat1;
        double dLon = lon2 - lon1;

        double a = Math.pow(Math.sin(dLat / 2), 2) +
                Math.cos(lat1) * Math.cos(lat2) *
                        Math.pow(Math.sin(dLon / 2), 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return earthRadius * c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the latitude of the first address:");
        double lat1 = scanner.nextDouble();
        System.out.println("Enter the longitude of the first address:");
        double lon1 = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.println("Enter the written address of the first address:");
        String writtenAddress1 = scanner.nextLine();

        Address address1 = new Address(lat1, lon1, writtenAddress1);

        System.out.println("Enter the latitude of the second address:");
        double lat2 = scanner.nextDouble();
        System.out.println("Enter the longitude of the second address:");
        double lon2 = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.println("Enter the written address of the second address:");
        String writtenAddress2 = scanner.nextLine();

        Address address2 = new Address(lat2, lon2, writtenAddress2);

        double distance = address1.getdistance_from(address2);
        System.out.println("The distance between the two addresses is: " + distance + " kilometers");
scanner.close();
    }
}

#Customer
import java.util.Scanner;

class Customer {
    private static int customerCounter = 0;
    private int customerNumber;
    private String name;
    private Address address;

    public Customer(String name, Address address) {
        this.customerNumber = ++customerCounter;
        this.name = name;
        this.address = address;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the customer:");
        String name = scanner.nextLine();

        System.out.println("Enter the latitude of the customer's address:");
        double latitude = scanner.nextDouble();
        System.out.println("Enter the longitude of the customer's address:");
        double longitude = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.println("Enter the written address of the customer:");
        String writtenAddress = scanner.nextLine();

        Address customerAddress = new Address(latitude, longitude, writtenAddress);
        Customer customer = new Customer(name, customerAddress);

        System.out.println("Customer number: " + customer.getCustomerNumber());
        System.out.println("Customer name: " + customer.getName());
        System.out.println("Customer address: " + customer.getAddress().getdistance_from(customer.getAddress()));
scanner.close();
    }
}

#food
import java.util.Vector;
import java.util.Scanner;

class Food {
    private static Vector<Food> menu = new Vector<>();
    private String name;
    private int price;

    public Food(String name, int price) {
        this.name = name;
        this.price = price;
        menu.add(this);
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the food:");
        String foodName = scanner.nextLine();

        System.out.println("Enter the price of the food:");
        int foodPrice = scanner.nextInt();
        scanner.nextLine();

        Food food = new Food(foodName, foodPrice);

        System.out.println("Food added to the menu:");
        System.out.println("Name: " + food.getName());
        System.out.println("Price: " + food.getPrice());

        System.out.println("\nMenu:");
        for (Food f : menu) {
            System.out.println("Name: " + f.getName() + ", Price: " + f.getPrice());
        }

        scanner.close();
    }
}

#Invoice
import java.util.ArrayList;
import java.util.Scanner;

class Invoice {
    private Customer customer;
    private ArrayList<Item> items;
    private int state;
    private static final float tax_rate = 9.4f;

    public Invoice(Customer customer) {
        this.customer = customer;
        this.items = new ArrayList<>();
        this.state = -1;
    }

    public boolean addItem(Item item) {
        if (state != -1) {
            return false;
        }

        items.add(item);
        return true;
    }

    public boolean removeItem(Item item) {
        if (state != -1 && items.contains(item)) {
            items.remove(item);
            return true;
        } else {
            return false;
        }
    }

    public void nextStage() {
        state++;
    }

    public int getTotalPrice() {
        int total = 0;
        for (Item item : items) {
        total += item.getFood().getPrice() * item.getCount();
        }
        total += Math.round(total * tax_rate / 100);
        return total;
        }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter customer name:");
        String customerName = scanner.nextLine();

        System.out.println("Enter customer address:");
        String customerAddress = scanner.nextLine();
        Address address = new Address(0.0, 0.0, customerAddress);
        Customer customer = new Customer(customerName, address);
        Invoice invoice = new Invoice(customer);

        System.out.println("Customer: " + invoice.customer.getName() + " - " + invoice.customer.getAddress());

        System.out.println("Adding items to the invoice:");
        System.out.println("Enter the name of the food:");
        String foodName = scanner.nextLine();
        System.out.println("Enter the price of the food:");
        int foodPrice = scanner.nextInt();
        scanner.nextLine(); 
        Food food = new Food(foodName, foodPrice);

        System.out.println("Enter the count of the item:");
        int count = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the description of the item:");
        String description = scanner.nextLine();

        Item item = new Item(food, count, description);
        boolean added = invoice.addItem(item);

        if (added) {
            System.out.println("Item added to the invoice successfully.");
        } else {
            System.out.println("Item could not be added to the invoice.");
        }

        System.out.println("Total price of the invoice (including tax): $" + invoice.getTotalPrice());

        scanner.close();
    }
}

#Item
import java.util.Scanner;
import java.util.Vector;


class Item {
    private Food food;
    private int count;
    private String description;

    public Item(Food food, int count, String description) {
        this.food = food;
        this.count = count;
        this.description = description;
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the food:");
        String foodName = scanner.nextLine();

        System.out.println("Enter the price of the food:");
        int foodPrice = scanner.nextInt();
        scanner.nextLine();

        Food food = new Food(foodName, foodPrice);

        System.out.println("Enter the count of the item:");
        int count = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the description of the item:");
        String description = scanner.nextLine();

        Item item = new Item(food, count, description);

        System.out.println("Item details:");
        System.out.println("Food: " + item.getFood().getName());
        System.out.println("Price: " + item.getFood().getPrice());
        System.out.println("Count: " + item.getCount());
        System.out.println("Description: " + item.getDescription());

        scanner.close();
    }
}
