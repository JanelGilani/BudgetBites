package Use_Cases.Login;
//Swami Shriji
import java.util.Scanner;
public class logiccode {
    public static void main(String[] args) {
    	
    	Scanner begin = new Scanner(System.in);
    	System.out.println("Are a new user? (Y/N):");
    	char entry = begin.next().charAt(0);
    	
    	Scanner fName = new Scanner(System.in);
    	Scanner lName = new Scanner(System.in);
    	Scanner userName = new Scanner(System.in);
    	Scanner pword = new Scanner(System.in);
    	Scanner cpword = new Scanner(System.in);
    	Scanner bget = new Scanner(System.in);
    	
    	String firstName;
    	String lastName;
    	String utorid;
    	String password;
    	String confirmPassword;
    	double budget;
    	
//    	
//    	String[][] users = new String[5][5];
    	
    	
    	if (entry == 'Y' || entry == 'y') {
    		
    		System.out.println("Enter first name");
    		firstName = fName.nextLine();
    		
    		System.out.println("Enter last name");
            lastName = lName.nextLine();
    		
            System.out.println("Enter UTORid");
            utorid = userName.nextLine();
            
          //check if utorid is correct
            int utoirdLen = utorid.length();
            if (utoirdLen == 8){
                System.out.println("Valid UTORid");
            } else{
                System.out.println("Incorrect UTORid");
            }
            
            System.out.println("Enter password");
            password = pword.nextLine();
            
            System.out.println("Enter confirmation password");
            confirmPassword = cpword.nextLine();
            
          //check if password and confirmation password is the same and strong
            if (password.equals(confirmPassword)){
                System.out.println("true");
                // check if password has uppercase special character and number
            } else {
                System.out.println("False");
            }
            
            System.out.println("Enter budget (optional)");
            budget = bget.nextDouble();
            
            
    	} else if (entry == 'N' || entry == 'n'){
    		System.out.println("Enter UTORid");
            utorid = userName.nextLine();
            
          //check if utorid is correct
            int utoirdLen = utorid.length();
            if (utoirdLen == 8){
                System.out.println("Valid UTORid");
            } else{
                System.out.println("Incorrect UTORid");
            }
            
            System.out.println("Enter password");
            password = pword.nextLine();
    	}
    	

        

        


    }

}
