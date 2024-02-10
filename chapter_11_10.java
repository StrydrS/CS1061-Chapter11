import java.util.Scanner;

public class chapter_11_10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter max value in Fibonacci series: ");
        fibonacci(input.nextInt());
        input.close();
    }

    public static void fibonacci(int value) {
        if (value < 0) {
            System.out.println("Not defined");
        } else if (value == 0) {
            System.out.println("0");
        } else {
            System.out.print("0");
            fibonacci(value, 1, 0);
            System.out.println();
        }
    }

    public static void fibonacci(int value, int a, int b) {
        if (value <= 0) {
            return;
        } else {
            int next = a + b;
            if(next > value) {
                return;
            }
            else {
                System.out.print(" " + next);
                fibonacci(value, b, next);
            }
        }
    }
}
