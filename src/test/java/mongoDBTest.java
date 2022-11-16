import Entities.User;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class mongoDBTest {
    @Test
    public void testUserCreation () {
        Object result = mainMongoDB.findAttributeByUsername("aryangoel24", "firstName");
        System.out.println(result);
    }
}
