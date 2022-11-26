package Entities;

import Use_Cases.ItemCart.itemCart;
import Use_Cases.ItemCart.pastOrders;

public class User {
    public String firstName;
    public String lastName;
    public String username;
    public String password;
    public Budget budget;
    public pastOrders pastOrders;

    public itemCart itemCart;
    
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
        return this.firstName;
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
