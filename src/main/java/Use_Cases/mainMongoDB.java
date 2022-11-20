package Use_Cases;

import Entities.*;
import Use_Cases.ItemCart.pastOrders;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.mongodb.ConnectionString;
import com.mongodb.DBObject;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import Use_Cases.ItemCart.itemCart;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.ClassModel;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;

import javax.print.attribute.standard.JobKOctets;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Locale;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.nin;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;


public class mainMongoDB {
//    Create all Class models
    static ClassModel<User> userClassModel = ClassModel.builder(User.class).enableDiscriminator(true).build();
    static ClassModel<Order> orderClassModel = ClassModel.builder(Order.class).enableDiscriminator(true).build();
    static ClassModel<pastOrders> pastOrdersClassModel = ClassModel.builder(pastOrders.class).enableDiscriminator(true).build();
    static ClassModel<foodItem> foodItemClassModel = ClassModel.builder(foodItem.class).enableDiscriminator(true).build();
    static ClassModel<Budget> budgetClassModel = ClassModel.builder(Budget.class).enableDiscriminator(true).build();
    static ClassModel<itemCart> itemCartClassModel = ClassModel.builder(itemCart.class).enableDiscriminator(true).build();

//    Create the Codec Registry with all the class models to allow MongoDB to store custom Objects
    static CodecRegistry pojoCodecRegistry = org.bson.codecs.configuration.CodecRegistries.fromRegistries(getDefaultCodecRegistry(), org.bson.codecs.configuration.CodecRegistries.fromProviders(PojoCodecProvider.builder()
            .register(userClassModel).register(orderClassModel).register(pastOrdersClassModel).register(foodItemClassModel).register(budgetClassModel).register(itemCartClassModel)
            .automatic(true).build()));
    static CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);

//    Connect to MongoDB server to the budgetbites database
    static MongoClient client = MongoClients.create("mongodb+srv://budgetbites:budgetbites@cluster0.f1q9roc.mongodb.net/?retryWrites=true&w=majority");
    static MongoDatabase db = client.getDatabase("budgetbites").withCodecRegistry(codecRegistry);

//    Obtain the User and Restaurant collections
    static MongoCollection<Restaurant> restaurantRepo = db.getCollection("restaurants", Restaurant.class);
    static MongoCollection<User> userRepo = db.getCollection("users", User.class);

//    Save new User or Restaurant to Database
    public static void saveUser (User user) {
        userRepo.insertOne(user);
    }

    public static void saveRestaurant (Restaurant restaurant) {
        restaurantRepo.insertOne(restaurant);
    }

//    Find User or Restaurant by username or restaurantname
    public static User findUserByUsername (String username) {
        return userRepo.find(eq("username", username)).first();
    }

    public static Restaurant findRestaurantByRestaurantName (String restaurantName) {
        return restaurantRepo.find(eq("restaurantName", restaurantName)).first();
    }

//    Check if user exists
    public static boolean userExists (String username) {
        return userRepo.find(eq("username", username)).first() != null;
    }

//    Past Orders
    public static pastOrders findPastOrders (String username) {
        User user = userRepo.find(eq("username", username)).first();
        if (user != null) {
            pastOrders currentPastOrder = user.getPastOrders();
            try {
                return currentPastOrder;
            } catch (NullPointerException e) {
                return null;
            }
        }
        return null;
    }

    public static boolean addToPastOrders (String username, Order order) {
        User user = userRepo.find(eq("username", username)).first();
        assert user != null;
        pastOrders pastOrders = user.getPastOrders();
        pastOrders.addOrder(order);

        Document query = new Document("username", username);
        Bson updates = Updates.set("pastOrders", pastOrders);
        UpdateOptions options = new UpdateOptions().upsert(true);

        userRepo.updateOne(query, updates, options);
        return true;
    }

    // Find attribute by username

    public static Object getUserAttribute (String username, String attribute) {
        User user  = userRepo.find(eq("username", username)).first();
        assert user !=  null;
        switch (attribute) {
            case "budget":
                return user.getBudget();
            case "firstName":
                return user.getFirstName();
            case "lastName":
                return user.getLastName();
            case "password":
                return user.getPassword();
        }
        return null;
    }

    // Find attribute by Restaurant

    public static Object getRestaurantAttribute (String restaurantName, String attribute) {
        Restaurant restaurant = restaurantRepo.find(eq("restaurantName", restaurantName)).first();
        assert restaurant != null;
        switch (attribute) {
            case "restaurantName":
                return restaurant.getRestaurantName();
            case "cuisine":
                return restaurant.getCuisine();
            case "priceRange":
                return restaurant.getPriceRange();
            case "foodType":
                return restaurant.getFoodType();
            case "avgRating":
                return restaurant.getAvgRating();
        }
        return null;
    }

    public static Object getMenu (String restaurantName){
        Restaurant res = restaurantRepo.find(eq("restaurantName", restaurantName)).first();
        if (res != null) {
            ArrayList<foodItem> menu = res.getMenu();
            try {
                return menu;
            } catch (NullPointerException e) {
                return null;
            }
        }
        return null;
    }

    public static void updateBudget (String username) {

    }

//    Update basic User or Restaurant attribute

    public static void updateAttributeByUsername (String username, String attribute, String attValue) {
        Document query = new Document("username", username);

        Bson updates = Updates.combine(
                Updates.set(attribute, attValue)
        );

        UpdateOptions options = new UpdateOptions().upsert(true);

        userRepo.updateOne(query, updates, options);
    }

    public static void updateAttributeByRestaurantName (String restaurantName, String attribute, Object attValue) {
        Document query = new Document("restaurantName", restaurantName);
        Bson updates = Updates.combine(Updates.set(attribute, attValue));
        UpdateOptions options = new UpdateOptions().upsert(true);

        restaurantRepo.updateOne(query, updates, options);
    }
}