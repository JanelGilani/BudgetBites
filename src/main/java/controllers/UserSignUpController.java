package controllers;

import usecases.signup.UserSignUpInteractor;

public class UserSignUpController {
    private final UserSignUpInteractor userSignUpInteractor;

    public UserSignUpController(){
        userSignUpInteractor = new UserSignUpInteractor();
    }

    public int signUpCheck(String username, String password, String confirmPassword) {
        return userSignUpInteractor.signUpCheck(username,password,confirmPassword);
    }

    public void register(String firstName, String lastName, double budget, String username, String password) {
        userSignUpInteractor.saveUser(firstName, lastName, username, password, budget);
    }
}
