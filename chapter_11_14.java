//as per Table 11.1 in the book, we can use the following method to solve big O growth
//rate for the tower of Hanoi problem.

//ans: O(2^n)
//input 4: 16
//input 16: 65535
//input 64: 1.8 e19 (very large)
//input 256: 1.2 e77 (very very large(cannot compute))

import java.util.Scanner;

public class chapter_11_14 {
    
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
