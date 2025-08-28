import java.util.*;
public class HelloWorld {
    public static void main(String[] args) {
    	  System.out.println("Welcome to the best program ever!");
    	 
    	 	Scanner input = new Scanner(System.in);
    	 	System.out.println("Enter your name: ");
    	 	String username = input.nextLine();
        System.out.println("Enter your password: ");
    	 	String password = input.nextLine();
    	 	System.out.println("Hello, " + username);
        System.out.println("Your password is " + password + ". You've been hacked!");
    }
}
