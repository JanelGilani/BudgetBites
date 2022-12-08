package controllers;

import usecases.RestaurantFilterDAI;
import gateways.MainMongoDB;
import usecases.filtering.restaurantfiltering.RestaurantFilterInteractor;

import java.util.ArrayList;
import java.util.HashMap;
//@SuppressWarnings({"ALL", "unused"})
public class RestaurantFilterController {

    private final RestaurantFilterDAI restaurantFilterDAI = new MainMongoDB();
    private final RestaurantFilterInteractor restaurantFiltersInteractor;

    public RestaurantFilterController() {
        ArrayList<String> restaurants = restaurantFilterDAI.getAllRestaurants();
        HashMap<String, ArrayList<String>> cuisineFilter = new HashMap<>();
        cuisineFilter.put("Italian",new ArrayList<>());
        cuisineFilter.put("Chinese",new ArrayList<>());
        cuisineFilter.put("Mexican",new ArrayList<>());
        cuisineFilter.put("Indian",new ArrayList<>());
        cuisineFilter.put("Middle-East",new ArrayList<>());

        HashMap<String, ArrayList<String>> foodTypeFilter = new HashMap<>();
        foodTypeFilter.put("Breakfast",new ArrayList<>());
        foodTypeFilter.put("Lunch",new ArrayList<>());
        foodTypeFilter.put("Dinner",new ArrayList<>());
        foodTypeFilter.put("Snack",new ArrayList<>());

        HashMap<String, ArrayList<String>> priceFilter = new HashMap<>();
        priceFilter.put("Cheap",new ArrayList<>());
        priceFilter.put("Intermediate",new ArrayList<>());
        priceFilter.put("Expensive",new ArrayList<>());

        String cuisine;
        String price;
        String foodType;
        for (String r: restaurants) {
            cuisine = restaurantFilterDAI.getRestaurantAttribute(r, "cuisine");
            price = restaurantFilterDAI.getRestaurantAttribute(r, "priceRange");
            foodType = restaurantFilterDAI.getRestaurantAttribute(r, "foodType");
            cuisineFilter.get(cuisine).add(r);
            foodTypeFilter.get(foodType).add(r);
            priceFilter.get(price).add(r);
        }

        restaurantFiltersInteractor = new RestaurantFilterInteractor(cuisineFilter,foodTypeFilter,priceFilter);
    }

    public ArrayList<String> getRestaurants(String pricePref, String cuisinePref, String foodTypePref) {
        if (pricePref.equals("No Preference") && cuisinePref.equals("No Preference") && foodTypePref.equals("No Preference")) {
            return restaurantFilterDAI.getAllRestaurants();
        } else {
            String priceChoice = pricePref.split("\\(",0)[0].strip();
            return restaurantFiltersInteractor.filter(priceChoice, cuisinePref, foodTypePref, restaurantFilterDAI.getAllRestaurants());

        }
    }
}
