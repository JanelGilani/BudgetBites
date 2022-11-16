package Entities;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String restaurantName;
    private String priceRange;
    private String cuisine;
    private String foodType;
    public double avgRating;
    protected ArrayList<foodItem> menu;
    public List<Object[]> reviews;

    public Restaurant (String name, String priceRange, String cuisine, String foodType, double avgRating, ArrayList<foodItem> menu) {
        this.restaurantName = name;
        this.priceRange = priceRange;
        this.cuisine = cuisine;
        this.foodType = foodType;
        this.avgRating = avgRating;
        this.menu = menu;
    }


    public String getPriceRange(){
        return this.priceRange;
    }

    public String getCuisine() {
        return this.cuisine;
    }

    public String getFoodType() {
        return this.foodType;
    }

    public String getRestaurantName () {return this.restaurantName;}

    public double getAvgRating () {
        return this.avgRating;
    }

    public ArrayList<foodItem> getMenu () {
        return this.menu;
    }

    public List<Object[]> getReviews () {
        return this.reviews;
    }


}
