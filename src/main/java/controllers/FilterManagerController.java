package controllers;

import gateways.RestaurantFilteringGateway;
import usecases.filtering.restaurantfiltering.filterManager;

import java.util.ArrayList;
import java.util.HashMap;

public class FilterManagerController {
    private filterManager restaurantFilters;

    public FilterManagerController() {
        ArrayList<String> restaurants = RestaurantFilteringGateway.getListOfRestaurants();
        HashMap<String, ArrayList<String>> cuisineFilter = new HashMap<>();
        cuisineFilter.put("Italian",new ArrayList<String>());
        cuisineFilter.put("Chinese",new ArrayList<String>());
        cuisineFilter.put("Thai",new ArrayList<String>());
        cuisineFilter.put("French",new ArrayList<String>());
        cuisineFilter.put("Arabic",new ArrayList<String>());
        cuisineFilter.put("Mexican",new ArrayList<String>());
        cuisineFilter.put("Indian",new ArrayList<String>());
        cuisineFilter.put("Middle-East",new ArrayList<String>());

        HashMap<String, ArrayList<String>> foodTypeFilter = new HashMap<>();
        foodTypeFilter.put("Breakfast",new ArrayList<String>());
        foodTypeFilter.put("Lunch",new ArrayList<String>());
        foodTypeFilter.put("Dinner",new ArrayList<String>());
        foodTypeFilter.put("Snack",new ArrayList<String>());

        HashMap<String, ArrayList<String>> priceFilter = new HashMap<>();
        priceFilter.put("Cheap",new ArrayList<String>());
        priceFilter.put("Intermediate",new ArrayList<String>());
        priceFilter.put("Expensive",new ArrayList<String>());

        String cuisine;
        String price;
        String foodType;
        for (String r: restaurants) {
            cuisine = RestaurantFilteringGateway.getRestaurantCuisine(r);
            price = RestaurantFilteringGateway.getRestaurantPriceRange(r);
            foodType = RestaurantFilteringGateway.getRestaurantFoodType(r);
            cuisineFilter.get(cuisine).add(r);
            foodTypeFilter.get(foodType).add(r);
            priceFilter.get(price).add(r);
        }

        restaurantFilters = new filterManager(cuisineFilter,foodTypeFilter,priceFilter);
    }

    public ArrayList<String> getRestaurants(String pricePref, String cuisinePref, String foodTypePref) {
        if (pricePref.equals("No Preference") && cuisinePref.equals("No Preference") && foodTypePref.equals("No Preference")) {
            return RestaurantFilteringGateway.getListOfRestaurants();
        } else {
            return restaurantFilters.filter(pricePref, cuisinePref, foodTypePref);
        }
    }
}
