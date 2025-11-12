
public class Hello {

    // public static void main(String[] args)
    public static void main(String ...args){
        // System.out.println("Hello, World!");
        // System.out.println("Hello, " + args[0] + " " + args[1]);
        String firstName = args[0];
        String lastName = args[1];
        System.out.println("Hello, " + firstName + " " + lastName + "!");
    }
}
