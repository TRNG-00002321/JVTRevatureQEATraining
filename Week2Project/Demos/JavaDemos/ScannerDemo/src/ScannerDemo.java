import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args){
        String firstName;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        firstName = scanner.next();
        System.out.println("Hello, " + firstName);
    }
}