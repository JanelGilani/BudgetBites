import Entities.Order;
import Use_Cases.mainMongoDB;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;


public class orderEntityTest {

    @Test
    public void getPriceRangeTest() {

        //Order restaurant = mainMongoDB.findPastOrders("aryangoel24");
        String price = "";

        Assertions.assertEquals("Intermediate", price);
    }
}