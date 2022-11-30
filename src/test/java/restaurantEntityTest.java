import Entities.Restaurant;
import Use_Cases.mainMongoDB;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;


public class restaurantEntityTest {

    @Test
    public void getPriceRangeTest() {

        Restaurant restaurant = mainMongoDB.findRestaurantByRestaurantName("Food from East");
        String price = restaurant.getPriceRange();

        Assertions.assertEquals("Intermediate", price);
    }

    @Test
    public void getCuisineTest() {

        Restaurant restaurant = mainMongoDB.findRestaurantByRestaurantName("Food from East");
        String cuisine = restaurant.getCuisine();

        Assertions.assertEquals("Middle-East", cuisine);
    }

    @Test
    public void getFoodType() {

        Restaurant restaurant = mainMongoDB.findRestaurantByRestaurantName("Food from East");
        String food = restaurant.getFoodType();

        Assertions.assertEquals("Lunch", food);
    }

    @Test
    public void getRestaurantNameTest() {

        Restaurant restaurant = mainMongoDB.findRestaurantByRestaurantName("Food from East");
        String name = restaurant.getRestaurantName();

        Assertions.assertEquals("Food from East", name);
    }

    @Test
    public void adjustBudgetIncreaseTest() {

        Restaurant restaurant = mainMongoDB.findRestaurantByRestaurantName("Food from East");
        double rating = restaurant.getAvgRating();

        Assertions.assertEquals(5, rating);
    }
}
