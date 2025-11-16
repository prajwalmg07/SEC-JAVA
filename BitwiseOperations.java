import java.util.Scanner;

public class BitwiseOperations {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first integer: ");
        int a = sc.nextInt();

        System.out.print("Enter second integer: ");
        int b = sc.nextInt();
        int andResult = a & b;
        int orResult = a | b;
        int xorResult = a ^ b;
        System.out.println("\n--- Binary Results ---");
        System.out.println("a        = " + Integer.toBinaryString(a));
        System.out.println("b        = " + Integer.toBinaryString(b));
        System.out.println("a AND b  = " + Integer.toBinaryString(andResult));
        System.out.println("a OR b   = " + Integer.toBinaryString(orResult));
        System.out.println("a XOR b  = " + Integer.toBinaryString(xorResult));
    }
}