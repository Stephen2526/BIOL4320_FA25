public class CommandArgsProgram {
    public static void main(String[] args) {
        System.out.println("This program prints command-line arguments");
        
        for (int i = 0; i < args.length; i++) {
            System.out.println("Argument " + i + ": " + args[i]);
        }
        
        System.out.println("Done printing command-line arguments");
    }
}
