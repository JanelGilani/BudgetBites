package controllers;

import usecases.login.LogicCode;

public class UserRegisterController {
    private LogicCode logicCode;

    public UserRegisterController(){
        logicCode = new LogicCode();
    }

    public int signUpCheck(String username, String password, String confirmPassword) {
        return logicCode.signUpCheck(username,password,confirmPassword);
    }

    public void register(String firstName, String lastName, double budget, String username, String password) {
        logicCode.saveUser(firstName, lastName, username, password, budget);
    }
}
