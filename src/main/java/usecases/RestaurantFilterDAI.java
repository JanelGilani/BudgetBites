package usecases;

import java.util.ArrayList;

public interface RestaurantFilterDAI {
    ArrayList<String> getAllRestaurants ();

    String getRestaurantAttribute (String restaurantName, String attribute);

}
