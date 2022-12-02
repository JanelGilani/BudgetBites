import entities.FoodItem;
import entities.Restaurant;
import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;


public class restaurantEntityTest {

    @Test
    public void getPriceRangeTest() {
        ArrayList<FoodItem> menu = new ArrayList<>();
        Restaurant restaurant = new Restaurant("McDonald's", "Cheap", "Fast-food", "Lunch", 5, menu);
        String price = restaurant.getPriceRange();

        Assertions.assertEquals("Cheap", price);
    }

    @Test
    public void getCuisineTest() {

        ArrayList<FoodItem> menu = new ArrayList<>();
        Restaurant restaurant = new Restaurant("McDonald's", "Cheap", "Fast-food", "Lunch", 5, menu);
        String cuisine = restaurant.getCuisine();

        Assertions.assertEquals("Fast-food", cuisine);
    }

    @Test
    public void getFoodType() {

        ArrayList<FoodItem> menu = new ArrayList<>();
        Restaurant restaurant = new Restaurant("McDonald's", "Cheap", "Fast-food", "Lunch", 5, menu);
        String food = restaurant.getFoodType();

        Assertions.assertEquals("Lunch", food);
    }

    @Test
    public void getRestaurantNameTest() {

        ArrayList<FoodItem> menu = new ArrayList<>();
        Restaurant restaurant = new Restaurant("McDonald's", "Cheap", "Fast-food", "Lunch", 5, menu);
        String name = restaurant.getRestaurantName();

        Assertions.assertEquals("McDonald's", name);
    }

    @Test
    public void getAvgRatingTest() {

        ArrayList<FoodItem> menu = new ArrayList<>();
        Restaurant restaurant = new Restaurant("McDonald's", "Cheap", "Fast-food", "Lunch", 5, menu);
        double rating = restaurant.getAvgRating();

        Assertions.assertEquals(5, rating);
    }

    @Test
    public void getMenuTest() {

        ArrayList<FoodItem> menu = new ArrayList<>();
        Restaurant restaurant = new Restaurant("McDonald's", "Cheap", "Fast-food", "Lunch", 5, menu);
        ArrayList test = restaurant.getMenu();

        Assertions.assertEquals(menu, test);
    }
}
