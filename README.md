# `Address Class`

This class represents an address and has two attributes latitude and longitude of type double to represent the geographical coordinates, and a written_address of type string to represent the textual address. It also has a method called distance_from that takes another Address object as input and returns the distance between the two points on the map in kilometers as a double variable, calculated using the formula:
  
$$distance = \sqrt{(la_2 - la_1)^{2} + (lo_2 - lo_1)^{2}}$$

* where lo represents the longitude and la represents the latitude.

# `Customer Class`

The objects of this class represent customers in the restaurant order management system. Each instance of this class has a unique customer number, which is a natural number, that is set automatically when the object is created and cannot be changed after that. This customer number can only be accessed using the getCustomerNumber method. Additionally, each customer has a string name that can be accessed and set using the getName and setName methods. Each customer also has an Address object, which can be accessed and set using the getAddress and setAddress methods.

# `Food Class`

Each object of this class represents a dish on the menu. This class should have a class variable called menu, which is a vector (or list) of Food objects, and any new Food object created will be automatically added to this menu. Each Food object has a string name and an integer price that are set in the constructor and cannot be changed after that. These values can only be accessed using the getName and getPrice methods, respectively. (Consider the potential problems that might arise if there was a setter method for the food prices in this system!)

# `Item Class`

Each object of this class represents an item in an order. Each Item object has a food attribute of the Food class that we defined earlier. It also has a positive integer count that represents the quantity, and a description attribute of type string that contains additional information about the item in the order. All three attributes are initialized in the constructor. However, the description can be left empty. After the object is created, these three attributes can only be read using the getFood, getCount, and getDescription methods, and should not be modifiable.

# `Invoice Class`

This class represents an invoice. Each invoice has an state attribute, which is an integer. If the state is 0, it means the order is in the preparation queue. If the state is 1, it means the order is in the shipping queue. If the state is 2, it means the order has been delivered to the customer. If the state is -1, it means the order is currently being placed. The getState() method can be used to read the state, but it cannot be changed outside the class.

Each Invoice object has a Customer object associated with it, which can be accessed using the getCustomer() method.

+ The only required input for the constructor of this class is the customer.

+ This class should have an addItem(Item item) method, which takes an Item object (as defined in the previous part) and adds it to the items of this invoice. This method should only work when the order is being placed. Otherwise, it should return false. If the item is added to the list of items for this order, it should return true.

+ This class should have a removeItem(Item item) method, which takes an Item object and removes it from the items of this invoice if it exists. (By "exists" we mean that there is an item with the same food in the items of this order.) This method should only work when the order is being placed. If the order is not in the placing state or the item does not exist in the items of this order, it should return false to indicate that the operation was not performed. If the operation is performed, it should return true.

+ The nextStage() method advances the order state by one stage.

+ The getTotalPrice() method returns the total price of the order as an integer. Note that the total price of the order is equal to the total price of the items plus the tax, and it is rounded up. The tax rate should be stored as a class variable in this class as a float variable named tax_rate, and its value should always be 9.4% and unchangeable.

The class should have at least one constructor that creates an Invoice object using the name and address of a Customer object.

The zip file includes the following Java files within the restaurant folder:

Address.java
Customer.java
Food.java
Item.java
Invoice.java
Restaurant.java

### Example (Main Function)

```
public static void main(String[] args) {
    Address a1 = new Address(2, 3, "Lahijan");
    Address a2 = new Address(5, 6, "Tehran");

    System.out.println("\n--------------------------------------\n");
    System.out.println("Distance From Address a1 to a2 is: " + a1.distanceFrom(a2));
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
```

#### Output
```
--------------------------------------

Distance From Address a1 to a2 is:4.24264

--------------------------------------

First Customer's ID: 1
Second Customer's ID: 2

--------------------------------------

Food Name: BURGER
Food Name: PIZZA
Food Name: PASTA

--------------------------------------

Items added successfully
Failed to remove item (item doesn't exist in invoice)
Current state: 0

--------------------------------------

Food Name: BURGER | Food Description: -
Food Name: PIZZA | Food Description: MORE SAUCE
Total price: 941
```
