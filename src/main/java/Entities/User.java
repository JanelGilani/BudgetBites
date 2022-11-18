package Entities;

<<<<<<< HEAD
import Use_Cases.itemCart;
import Use_Cases.pastOrders;
import org.bson.codecs.pojo.annotations.BsonProperty;
=======
import Use_Cases.ItemCart.itemCart;
import Use_Cases.ItemCart.pastOrders;
>>>>>>> ba837d9ef596f639fc25b433f4ea0f634f33bd10

public class User {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Budget budget;
    private pastOrders pastOrders;

    private itemCart itemCart;

//    public User (String firstName, String lastName, String username, String password, Budget budget) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.username = username;
//        this.password = password;
//        this.budget = budget;
//        this.pastOrders = new pastOrders();
//        this.itemCart = new itemCart();
//    }
//
//    public User (String firstName, String lastName, String username, String password) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.username = username;
//        this.password = password;
//        this.budget = new Budget();
//        this.pastOrders = new pastOrders();
//        this.itemCart = new itemCart();
//    }
//
//    public User (String firstName, String lastName, String username, String password, pastOrders pastOrders) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.username = username;
//        this.password = password;
////        this.budget = new Budget();
//        this.pastOrders = pastOrders;
////        this.itemCart = new itemCart();
//    }

    public User () {
    }

    public User (String firstName, String lastName, String username, String password, pastOrders pastOrders, Budget budget) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.budget = budget;
        this.pastOrders = pastOrders;
//        this.itemCart = new itemCart();
    }

    public String getFirstName () {
        return firstName;
    }

    public String getLastName () {
        return lastName;
    }

    public String getUsername () {
        return username;
    }

    public String getPassword () {
        return password;
    }

    public pastOrders getPastOrders () {
        return pastOrders;
    }

    public Budget getBudget () {return budget;}


}
