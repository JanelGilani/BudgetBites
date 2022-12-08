package ui;

import controllers.LoginController;
import presenters.LoginPresenter;

import javax.swing.*;

public class LoginResultLabel extends JLabel implements LoginPresenter {
    private LoginController loginController;

    public LoginResultLabel() {
        this.setBounds(10, 160, 300, 25);
        loginController = new LoginController();
    }

    @Override
    public void setResponse(String username, String password) {
        int val = loginController.loginCheck(username, password);
        if (val == 2) {
            this.setText("Success");
        } else if (val == 1) {
            this.setText("Incorrect Password");
        } else if (val == 0) {
            this.setText("Username Does Not Exist");
        }
    }

    @Override
    public String getMessage() {
        return this.getText();
    }
}
