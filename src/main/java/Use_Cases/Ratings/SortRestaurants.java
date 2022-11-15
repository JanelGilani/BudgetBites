package Use_Cases.Ratings;

import Entities.Restaurant;

import java.util.Arrays;

public class SortRestaurants {
    private Restaurant[] SortRestaurants(Restaurant[] r){
        Arrays.sort(r, new RatingComparator());
        return r;
    }
}
