package Entities;

public class User {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private Budget budget;

    public User (String firstName, String lastName, String username, String password, Budget budget) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.budget = budget;
    }
}
