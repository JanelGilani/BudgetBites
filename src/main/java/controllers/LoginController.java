package controllers;

import usecases.login.Login;

public class LoginController {
    private Login login;

    public LoginController() {
        login = new Login();
    }

    public int loginCheck(String user, String password) {
        return login.loginCheck(user, password);
    }
}
