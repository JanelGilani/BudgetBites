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

public class logiccode {
    public static void main(String[] args) {
        logiccode.signUpCheck("vandanpatel", "Vp@1232848327498473", "Vp@1232848327498473", 50, "Vandan", "Patel");
    }

    //Checks the strength of the password
    public static boolean strongPassword (String password){
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

        // Strength of password
        if (hasDigit && hasUpper && specialChar && (n >= 10))
            return true;
        else
            return false;
    }

    //checks if both inputted passwords are the same
    public static boolean samePassword(String password, String confirmPassword){
        if (password.equals(confirmPassword)){
            return true;
        } else{
            return false;
        }
    }

    public static boolean signUpCheck(String username, String password, String confirmPassword, double initialBudget, String firstName, String lastName) {
        // help with mainMongoDB
        if (mainMongoDB.userExists(username)) {
            return false;
        } else {
            if (samePassword(password, confirmPassword)) {
                if (strongPassword(password)) {
                    pastOrders p1 = new pastOrders();
                    Budget b1 = new Budget(initialBudget);
                    User user = new User(firstName, lastName, username, password, p1, b1);
                    mainMongoDB.saveUser(user);
                    return true;
                } else {
                    // final code should be able to tell the user that this password isn't strong
                    return false;
                }
            } else {
                // final code should be able to tell the user that password and confirm password are the same
                return false;
            }
        }
    }


//    	Scanner begin = new Scanner(System.in);
//    	System.out.println("Are a new user? (Y/N):");
//    	char entry = begin.next().charAt(0);
//
//    	Scanner fName = new Scanner(System.in);
//    	Scanner lName = new Scanner(System.in);
//    	Scanner userName = new Scanner(System.in);
//    	Scanner pword = new Scanner(System.in);
//    	Scanner cpword = new Scanner(System.in);
//    	Scanner bget = new Scanner(System.in);
//
//    	String firstName;
//    	String lastName;
//    	String utorid;
//    	String password;
//    	String confirmPassword;
//    	double budget;
//
////
////    	String[][] users = new String[5][5];
//
//
//    	if (entry == 'Y' || entry == 'y') {
//
//    		System.out.println("Enter first name");
//    		firstName = fName.nextLine();
//
//    		System.out.println("Enter last name");
//            lastName = lName.nextLine();
//
//            System.out.println("Enter UTORid");
//            utorid = userName.nextLine();
//
//          //check if utorid is correct
//            int utoirdLen = utorid.length();
//            if (utoirdLen == 8){
//                System.out.println("Valid UTORid");
//            } else{
//                System.out.println("Incorrect UTORid");
//            }
//
//            System.out.println("Enter password");
//            password = pword.nextLine();
//
//            System.out.println("Enter confirmation password");
//            confirmPassword = cpword.nextLine();
//
//          //check if password and confirmation password is the same and strong
//            if (password.equals(confirmPassword)){
//                System.out.println("true");
//                // check if password has uppercase special character and number
//            } else {
//                System.out.println("False");
//            }
//
//            System.out.println("Enter budget (optional)");
//            budget = bget.nextDouble();
//
//
//    	} else if (entry == 'N' || entry == 'n'){
//    		System.out.println("Enter UTORid");
//            utorid = userName.nextLine();
//
//          //check if utorid is correct
//            int utoirdLen = utorid.length();
//            if (utoirdLen == 8){
//                System.out.println("Valid UTORid");
//            } else{
//                System.out.println("Incorrect UTORid");
//            }
//
//            System.out.println("Enter password");
//            password = pword.nextLine();
//    	}
//       }

}
