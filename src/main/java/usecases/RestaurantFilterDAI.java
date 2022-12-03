package usecases;

import java.util.ArrayList;

import static com.mongodb.client.model.Filters.eq;

public interface RestaurantFilterDAI {
    public ArrayList<String> getAllRestaurants ();

    public String getRestaurantAttribute (String restaurantName, String attribute);

}
