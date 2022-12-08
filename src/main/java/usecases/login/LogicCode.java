//Swami Shriji
package usecases.login;
import usecases.LoginDAI;
import gateways.MainMongoDB;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LogicCode {

    private final LoginDAI loginDAI = new MainMongoDB();


    /**
     * The following code checks the strength of the password by checking if the password entered meets the following criteria: uppercase, digit, special character and is 10 characters long.
     * @param password inputted by the user
     * @return boolean
     */
    public boolean strongPassword (String password){
        int n = password.length();
        boolean hasUpper = false;
        boolean hasDigit = false;
        boolean specialChar = false;
        Set<Character> set = new HashSet<Character>(
                Arrays.asList('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+', '.', '_'));
        for (char i : password.toCharArray())
        {
            if (Character.isUpperCase(i))
                hasUpper = true;
            if (Character.isDigit(i))
                hasDigit = true;
            if (set.contains(i))
                specialChar = true;
        }

        // checks the strength of the password by if the password has an uppercase, digit, special character and password length
        if (hasUpper && hasDigit && specialChar && (password.length() >= 10)) {
            return true;
        }else {
            return false;
        }
    }

    /**
     * checks if both passwords inputted password and confirm password are the same
     * @param password inputted by the user
     * @param confirmPassword inputted by the user
     * @return boolean
     */
    public boolean samePassword(String password, String confirmPassword){
        if (password.equals(confirmPassword)){
            return true;
        } else{
            return false;
        }
    }

    /**
     * signs up and saves the user data if the user doesn't exist, password and confirm password are the same and the password is strong.
     * @param username inputted by the user
     * @param password inputted by the user
     * @param confirmPassword inputted by the user
     * @return boolean
     */
    public int signUpCheck(String username, String password, String confirmPassword) {
        if (loginDAI.userExists(username)) {
            return 0;
        } else {
            if (samePassword(password, confirmPassword)) {
                if (strongPassword(password)) {
                    // all requirements match for user to save inputted data
                    return 3;
                } else {
                    // tell the user that this password isn't strong
                    return 2;
                }
            } else {
                // tell the user that password and confirm password are the same
                return 1;
            }
        }
    }
}
