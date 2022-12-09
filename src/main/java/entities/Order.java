package entities;

import java.util.ArrayList;

public class Order {
    public ArrayList<FoodItem> orderedItems;
    public String dateOrdered;
    public double totalCost;
    public String restaurantName;

// Instantiating order
    public Order () {
        this.dateOrdered = null;
        this.totalCost = 0;
        this.orderedItems = new ArrayList<>();
        this.restaurantName = "";
    }

    /**
     * Instantiating new order
     * @param dateOrdered date ordered of the food item
     * @param restaurantName restaurant of the food item
     */
    public Order (String dateOrdered, String restaurantName) {
        this.dateOrdered = dateOrdered;
        this.totalCost = 0;
        this.orderedItems = new ArrayList<>();
        this.restaurantName = restaurantName;
    }

    /**
     * Returns an array list of ordered food items
     * @return Array list of food items
     */
    public ArrayList<FoodItem> getOrderedItems () {
        return this.orderedItems;
    }

    /**
     * Getter for date order
     * @return Date when the order was placed
     */
    public String getDateOrdered () {
        return this.dateOrdered;
    }

    /**
     * Getter for total cost
     * @return return the total cost of the order
     */
    public double getTotalCost () {
        return this.totalCost;
    }

    /**
     * Getter for restaurant name
     * @return name of the restaurant in form of a string
     */
    public String getRestaurantName () {
        return this.restaurantName;
    }

    /**
     * Add to order of all the food item in the cart
     * @param item food items
     */
    public void addToOrder (FoodItem item) {
        this.orderedItems.add(item);
        this.totalCost += item.getItemCost();
        }



}
