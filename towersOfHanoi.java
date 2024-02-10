import java.util.Scanner;

public class towersOfHanoi {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of discs in the tower of Hanoi: " );
        int numDiscs = input.nextInt(); // You can change this to the number of discs you want

        // Record start time
        long startTime = System.nanoTime();

        // Call the method to solve Towers of Hanoi
        int moves = solveTowersOfHanoi(numDiscs, 'A', 'C', 'B');

        // Record end time
        long endTime = System.nanoTime();

        System.out.println("Minimum number of moves: " + moves);
        System.out.println("Runtime: " + (endTime - startTime) + " nanoseconds");
        input.close();
    }

    public static int solveTowersOfHanoi(int n, char source, char destination, char intermediate) {
        // Base case: If there is only one disc, move it from source to destination
        if (n == 1) {
            return 1;
        }
        else {
            // Move (n-1) discs from source to intermediate peg using destination as intermediate
        int moves1 = solveTowersOfHanoi(n - 1, source, intermediate, destination);

        // Move (n-1) discs from intermediate peg to destination using source as intermediate
        int moves2 = solveTowersOfHanoi(n - 1, intermediate, destination, source);

        // Total moves is the sum of moves1, 1 (for the current move), and moves2
        return moves1 + 1 + moves2;
        }
    }
}
