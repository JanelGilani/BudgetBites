package restaurantFilter;

import usecases.filtering.restaurantfiltering.RestaurantFilterInteractor;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RestaurantFilterInteractorTest {
    /**
     * Creates ArrayList with cuisine, Food Type, and expense
     */
    private final ArrayList<String> allRestaurants = new ArrayList<>(Arrays.asList(
            "Italian Breakfast Cheap", "Chinese Lunch Cheap", "Thai Dinner Expensive", "French Lunch Intermediate",
            "Arabic Snack Cheap", "Indian Dinner Intermediate", "Middle-East Lunch Expensive", "Chinese Snack Expensive",
            "Mexican Breakfast Intermediate"));

    /**
     * Generates a fillter manager hashmap that stores cuisine, food type, and price fliter
     * @return RestaurantFilterInteractor which has a hashmap of cuisineFilter, foodTypeFilter, and priceFilter
     */
    public static RestaurantFilterInteractor generateFilterManager() {
        HashMap<String, ArrayList<String>> cuisineFilter = new HashMap<>();
        cuisineFilter.put("Italian",new ArrayList<>());
        cuisineFilter.put("Chinese",new ArrayList<>());
        cuisineFilter.put("Thai",new ArrayList<>());
        cuisineFilter.put("French",new ArrayList<>());
        cuisineFilter.put("Arabic",new ArrayList<>());
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

        String restaurant = "Italian Breakfast Cheap";
        cuisineFilter.get("Italian").add(restaurant);
        foodTypeFilter.get("Breakfast").add(restaurant);
        priceFilter.get("Cheap").add(restaurant);

        restaurant = "Chinese Lunch Cheap";
        cuisineFilter.get("Chinese").add(restaurant);
        foodTypeFilter.get("Lunch").add(restaurant);
        priceFilter.get("Cheap").add(restaurant);

        restaurant = "Thai Dinner Expensive";
        cuisineFilter.get("Thai").add(restaurant);
        foodTypeFilter.get("Dinner").add(restaurant);
        priceFilter.get("Expensive").add(restaurant);

        restaurant = "French Lunch Intermediate";
        cuisineFilter.get("French").add(restaurant);
        foodTypeFilter.get("Lunch").add(restaurant);
        priceFilter.get("Intermediate").add(restaurant);

        restaurant = "Arabic Snack Cheap";
        cuisineFilter.get("Arabic").add(restaurant);
        foodTypeFilter.get("Snack").add(restaurant);
        priceFilter.get("Cheap").add(restaurant);

        restaurant = "Indian Dinner Intermediate";
        cuisineFilter.get("Indian").add(restaurant);
        foodTypeFilter.get("Dinner").add(restaurant);
        priceFilter.get("Intermediate").add(restaurant);

        restaurant = "Middle-East Lunch Expensive";
        cuisineFilter.get("Middle-East").add(restaurant);
        foodTypeFilter.get("Lunch").add(restaurant);
        priceFilter.get("Expensive").add(restaurant);

        restaurant = "Chinese Snack Expensive";
        cuisineFilter.get("Chinese").add(restaurant);
        foodTypeFilter.get("Snack").add(restaurant);
        priceFilter.get("Expensive").add(restaurant);

        restaurant = "Mexican Breakfast Intermediate";
        cuisineFilter.get("Mexican").add(restaurant);
        foodTypeFilter.get("Breakfast").add(restaurant);
        priceFilter.get("Intermediate").add(restaurant);

        return new RestaurantFilterInteractor(cuisineFilter, foodTypeFilter, priceFilter);
    }

    /**
     * Tests if the filter manager works for one cuisine preference
     */
    @Test
    public void filterManagerOneCuisinePreference() {
        ArrayList<String> obj = new ArrayList<>(
                Arrays.asList("Chinese Lunch Cheap","Chinese Snack Expensive"));
        RestaurantFilterInteractor restaurantFilterInteractor = RestaurantFilterInteractorTest.generateFilterManager();
        Assertions.assertEquals(obj, restaurantFilterInteractor.filter("No Preference", "Chinese", "No Preference", allRestaurants));
    }

    /**
     * Tests if the filter manager works for one price preference
     */
    @Test
    public void filterManagerOnePricePreference() {
        ArrayList<String> obj = new ArrayList<>(
                Arrays.asList("Italian Breakfast Cheap","Chinese Lunch Cheap", "Arabic Snack Cheap"));
        RestaurantFilterInteractor restaurantFilterInteractor = RestaurantFilterInteractorTest.generateFilterManager();
        Assertions.assertEquals(obj, restaurantFilterInteractor.filter("Cheap", "No Preference", "No Preference", allRestaurants));
    }

    /**
     * Tests if the filter manager works for one food type preference
     */
    @Test
    public void filterManagerOneFoodTypePreference() {
        ArrayList<String> obj = new ArrayList<>(
                Arrays.asList("Chinese Lunch Cheap", "French Lunch Intermediate", "Middle-East Lunch Expensive"));
        RestaurantFilterInteractor restaurantFilterInteractor = RestaurantFilterInteractorTest.generateFilterManager();
        Assertions.assertEquals(obj, restaurantFilterInteractor.filter("No Preference", "No Preference", "Lunch", allRestaurants));
    }

    /**
     * Tests if the filter manager works for food type and price preferences
     */
    @Test
    public void filterManagerPriceFoodTypePreference() {
        ArrayList<String> obj = new ArrayList<>(
                List.of("Mexican Breakfast Intermediate"));
        RestaurantFilterInteractor restaurantFilterInteractor = RestaurantFilterInteractorTest.generateFilterManager();
        Assertions.assertEquals(obj, restaurantFilterInteractor.filter("Intermediate", "No Preference", "Breakfast", allRestaurants));
    }

    /**
     * Tests if the filter manager works for cuisine and price preferences
     */
    @Test
    public void filterManagerPriceCuisinePreference() {
        ArrayList<String> obj = new ArrayList<>(
                List.of("Thai Dinner Expensive"));
        RestaurantFilterInteractor restaurantFilterInteractor = RestaurantFilterInteractorTest.generateFilterManager();
        Assertions.assertEquals(obj, restaurantFilterInteractor.filter("Expensive", "Thai", "No Preference", allRestaurants));
    }

    /**
     * Tests if the filter manager works for food type and cuisine preferences
     */
    @Test
    public void filterManagerFoodTypeCuisinePreference() {
        ArrayList<String> obj = new ArrayList<>(
                List.of("French Lunch Intermediate"));
        RestaurantFilterInteractor restaurantFilterInteractor = RestaurantFilterInteractorTest.generateFilterManager();
        Assertions.assertEquals(obj, restaurantFilterInteractor.filter("No Preference", "French", "Lunch", allRestaurants));
    }

    /**
     * Tests if the filter manager works for all preferences
     */
    @Test
    public void filterManagerAllPreference() {
        ArrayList<String> obj = new ArrayList<>(
                List.of("Indian Dinner Intermediate"));
        RestaurantFilterInteractor restaurantFilterInteractor = RestaurantFilterInteractorTest.generateFilterManager();
        Assertions.assertEquals(obj, restaurantFilterInteractor.filter("Intermediate", "Indian", "Dinner", allRestaurants));
    }
}
