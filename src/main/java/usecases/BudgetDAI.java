package usecases;

import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import entities.PastOrders;
import entities.User;
import org.bson.Document;
import org.bson.conversions.Bson;

import static com.mongodb.client.model.Filters.eq;

public interface BudgetDAI {
    public void updateAttributeByUsername(String username, String attribute, Object attValue);

    public Object getUserAttribute(String username, String attribute);

    public boolean userExists (String username);

    public PastOrders findPastOrders (String username);
}
