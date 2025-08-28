import java.util.*;
public class StdInputProgram {
    public static void main(String[] args) {
        System.out.println("This program reads from stdin");
     
        Scanner input = new Scanner(System.in);
        System.out.print("Enter some text: ");

        while (input.hasNextLine()) {
            String text = input.nextLine();
            System.out.println("You entered: " + text);
            System.out.print("Enter some text: ");
        }

        System.out.println();
        System.out.println("Done reading from stdin");
    }
}
