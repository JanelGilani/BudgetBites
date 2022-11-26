package ratings;

import Use_Cases.Ratings.avgRatingManager;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class avgRatingManagerTest {

    @Test
    public void avgRatingManagerAverage(){

        avgRatingManager arm  = new avgRatingManager();
        arm.setSumRatings(10);
        arm.setNumRatings(2);
        arm.calculateRatingAverage();
        Assertions.assertEquals(5, arm.getAvgRating());
    }

}
