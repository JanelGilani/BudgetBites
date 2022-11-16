import Entities.Order;
import Entities.Restaurant;
import Entities.User;
import Use_Cases.pastOrders;
import com.mongodb.DBObject;
import com.mongodb.client.*;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import Use_Cases.itemCart;
import Entities.foodItem;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class mainMongoDB {

    static CodecRegistry pojoCodecRegistry = org.bson.codecs.configuration.CodecRegistries.fromRegistries(getDefaultCodecRegistry(), org.bson.codecs.configuration.CodecRegistries.fromProviders(PojoCodecProvider.builder().automatic(true).build()));

    static MongoClient client = MongoClients.create("mongodb+srv://budgetbites:budgetbites@cluster0.vemeub4.mongodb.net/?retryWrites=true&w=majority");
    static MongoDatabase db = client.getDatabase("budgetbites").withCodecRegistry(pojoCodecRegistry);

    static MongoCollection<Document> restaurantRepo = db.getCollection("restaurants");
    static MongoCollection<Document> userRepo = db.getCollection("users").withCodecRegistry(pojoCodecRegistry);

    public mainMongoDB () {
    }

    public static void main(String[] args) {
//        List<foodItem> newFood = new ArrayList<>();
//        foodItem chicken = new foodItem("chicken", 10);
//        newFood.add(chicken);
//        Document sampleDoc = new Document("_id", "5").append("foodItem", newFood);
//        userRepo.insertOne(sampleDoc);

//        foodItem foodItem1 = new foodItem("Chicken", 10);
//        foodItem foodItem2 = new foodItem("Fish", 8);
//        ArrayList<foodItem> menu = new ArrayList<foodItem>();
//        menu.add(foodItem1);
//        menu.add(foodItem2);
//        Restaurant restaurant = new Restaurant("Food from West", "moderate", "Middle-East", "Lunch", 5, menu);
//
//        saveRestaurant(restaurant);
//        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
//        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
//        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider.builder().automatic(true).build()));



//        User user2 = new User("Janel", "Gilani", "jjg", "abcde");
//        Document doc = new Document();
//        doc.put("firstName", user1.getFirstName());
//        doc.put("lastName", user1.getLastName());
//        doc.put("username", user1.getUsername());
//        doc.put("password", user1.getPassword());

//        saveUser(user2);

//        updateAttributeByUsername("aryangoel24", "password", "abcdef");
//        foodItem newFood = new foodItem("Kebab", 4);
//        foodItem newFood1 = new foodItem("Hummus", 8);
//        foodItem newFood2 = new foodItem("Food", 12);
//        updateAttributeByRestaurantName("Food from West", "menu", newFood);
//
//        Order order = new Order(LocalDateTime.now());
//        order.addToOrder(newFood);
//        order.addToOrder(newFood1);
//
//        Order order1 = new Order(LocalDateTime.now());
//        order1.addToOrder(newFood);
//        order1.addToOrder(newFood2);
//
//
//        pastOrders pastOrders = new pastOrders();
//        pastOrders.addOrder(order);
//        pastOrders.addOrder(order1);
//
//        User user = new User("Nikita", "Tugnait", "nikita", "nik", pastOrders);
//        saveUser(user);

//        Document userDoc = new Document("_id", 25).append("user", user1);
//        userRepo.insertOne(doc);

//        Document sampleDoc = new Document("_id", 3).append("restaurant", restaurant);
//        restaurantRepo.insertOne(sampleDoc);

//        System.out.println(findAttributeByUsername("aryangoel24", "firstName"));
//        System.out.println(findAttributeByRestaurantName(""));

        System.out.println(findPastOrders("nikita"));
    }

    public static void saveUser (User user) {
        Document doc = new Document();
        doc.put("firstName", user.getFirstName());
        doc.put("lastName", user.getLastName());
        doc.put("username", user.getUsername());
        doc.put("password", user.getPassword());
        doc.put("pastOrders", user.getPastOrders());
        userRepo.insertOne(doc);
    }

    public static void saveRestaurant (Restaurant restaurant) {
        Document doc = new Document();
        doc.put("restaurantName", restaurant.getRestaurantName());
        doc.put("cuisine", restaurant.getCuisine());
        doc.put("priceRange", restaurant.getPriceRange());
        doc.put("foodType", restaurant.getFoodType());
        doc.put("avgRating", restaurant.getAvgRating());
        doc.put("menu", restaurant.getMenu());
        doc.put("reviews", restaurant.getReviews());
        restaurantRepo.insertOne(doc);
    }
//
    public static Object findAttributeByUsername (String username, String attribute) {
//        Attribute must match exactly to one of the following: firstName, lastName, username, password, pastOrders
        Document userDoc = userRepo.find(eq("username", username)).first();
        return userDoc.get(attribute);
    }

    public static Object findPastOrders (String username) {
        Document pastOrders = userRepo.find(eq("username", username)).first();
        return pastOrders.get("pastOrdersMap");

    }

    public static Object findAttributeByRestaurantName (String restaurantName, String attribute) {
//        Attribute must match exactly to one of the following: restaurantName, cuisine, priceRange, foodType, avgRating, menu, reviews
        Document restaurantDoc = restaurantRepo.find(eq("restaurantName", restaurantName)).first();
        return restaurantDoc.get(attribute);
    }

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
        Bson updates;

        if (attribute == "menu" || attribute == "reviews") {
            updates = Updates.combine(Updates.addToSet(attribute, attValue));
        }
        else {
            updates = Updates.combine(Updates.set(attribute, attValue));
        }

        UpdateOptions options = new UpdateOptions().upsert(true);

        restaurantRepo.updateOne(query, updates, options);
    }
}