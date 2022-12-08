package controllers;

import usecases.login.UserLoginInteractor;
//@SuppressWarnings({"ALL", "unused"})

public class UserLoginController {
    private final UserLoginInteractor userLoginInteractor;

    public UserLoginController() {
        userLoginInteractor = new UserLoginInteractor();
    }

    public int loginCheck(String user, String password) {
        return userLoginInteractor.loginCheck(user, password);
    }
}
