import java.util.Scanner;

public class chapter_11_6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n;

        System.out.print("Enter a non-negative number: ");
        n = input.nextInt();
         // Initial call with accumulator set to 1
        if(n >= 0) {
            System.out.println(factorial(n, 1));
        }

        input.close();
    }
    
    //new factorial method using tail recursion
    private static long factorial(int n, long accumulator) {
        if(n == 0 || n == 1) {
            return accumulator;
        }
            else {
                return factorial(n - 1, n * accumulator);
            }
        }
    }
