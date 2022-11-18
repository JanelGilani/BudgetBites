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
import org.bson.BsonDocument;
import org.bson.Document;
import Use_Cases.ItemCart.itemCart;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.ClassModel;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
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
    static MongoClient client = MongoClients.create("mongodb+srv://budgetbites:budgetbites@cluster0.vemeub4.mongodb.net/?retryWrites=true&w=majority");
    static MongoDatabase db = client.getDatabase("budgetbites").withCodecRegistry(codecRegistry);

//    Obtain the User and Restaurant collections
    static MongoCollection<Restaurant> restaurantRepo = db.getCollection("restaurants", Restaurant.class);
    static MongoCollection<User> userRepo = db.getCollection("users", User.class);

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
//        foodItem newFood3 = new foodItem("Shawarma", 7);
//////        updateAttributeByRestaurantName("Food from West", "menu", newFood);
////
//        Order order = new Order(LocalDateTime.now().minusHours(2).toString());
//        order.addToOrder(newFood);
//        order.addToOrder(newFood1);
////
//        Order order1 = new Order(LocalDateTime.now().minusHours(1).toString());
//        order1.addToOrder(newFood3);
//        order1.addToOrder(newFood2);
////
////
//        pastOrders pastOrders = new pastOrders();
//        pastOrders.addOrder(order);
//        pastOrders.addOrder(order1);
//
//        Budget budget = new Budget(100);
////
//        User user = new User("Aryan", "Goel", "aryangoel24", "aryangoel24", pastOrders, budget);
//        saveUser(user);

//        Document userDoc = new Document("_id", 25).append("user", user1);
//        userRepo.insertOne(doc);

//        Document sampleDoc = new Document("_id", 3).append("restaurant", restaurant);
//        restaurantRepo.insertOne(sampleDoc);

//        System.out.println(findAttributeByUsername("aryangoel24", "firstName"));
//        System.out.println(findAttributeByRestaurantName(""));

//        System.out.println(findPastOrders("nikita"));
//        System.out.println(userExists("ag"));

//        System.out.println(findAttributeByUsername("nikita", "pastOrders"));

//        System.out.println(findPastOrders("ag24"));
//        System.out.println(findPastOrders("ag24").getLastOrdered());
//        System.out.println(findPastOrders("ag24").pastOrdersMap.get("2022-11-16T15:09:09.288516"));
//        System.out.println(userRepo.find(eq("username", "rg66")).first().getPastOrders().getOrderedItemsByDate("2022-11-16T17:53:27.399046"));
//        Order order = new Order(LocalDateTime.now().toString());
//        foodItem f1 = new foodItem("Hamburger", 20);
//        order.addToOrder(f1);
//        addToPastOrders("aryangoel24", order);
    }

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

    //Find attribute by username
    public static Object getAttribute (String username, String attribute) {
        User user = userRepo.find(eq("username", username)).first();
        assert user != null;
        switch (attribute) {
            case "budget":
                return user.getBudget();
            case "password":
                return user.getPassword();
            case "firstname":
                return user.getFirstName();
            case "lastname":
                return user.getLastName();
        }
        return null;
    }


//    Budget
//    public static Budget findBudget (String username) {
//        User user = userRepo.find(eq("username", username)).first();
//        assert user != null;
//        return user.getBudget();
//    }

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