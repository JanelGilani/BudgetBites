package usecases;

import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;

public interface BudgetDAI {
    public void updateAttributeByUsername (String username, String attribute, Object attValue);
}
