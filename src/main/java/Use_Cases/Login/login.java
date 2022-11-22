//Swami Shriji
package Use_Cases.Login;
import Entities.Budget;
import Entities.User;
import Use_Cases.ItemCart.pastOrders;
import Use_Cases.mainMongoDB;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.io.*;

public class login {
    public static boolean loginCheck(String user, String password){
        if (mainMongoDB.userExists(user)){
            String correctPassword = (String) mainMongoDB.getUserAttribute(user, "password");
            if (password.equals(correctPassword)){
                return true;
            } else {
                // final submission on gui should be able to say "Incorrect Password"
                return false;
            }
        } else{
            return false;
            //System.out.println("username doesn't exist");
        }
    }

    public static void main(String[] args) {
        login.loginCheck("aryangoel24", "goelaryan25");
    }
}
