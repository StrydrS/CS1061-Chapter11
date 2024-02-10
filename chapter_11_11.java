//After getting your program to work, run it with different inputs, and use what you find
//to describe how y(k) converges for different ranges of gain.

// logistic equation implementation
//y(k) = y(k-1) + gain * y(k-1) * (1.0 - y(k-1))

// Answer: y(k) for gain 0.05 < x < 2: converges to 1
//              for gain 2.0 < x < 3.5: does not converge
//              for gain 3.5 < x < 1000: does not converge

import java.util.Scanner;

public class chapter_11_11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //avoid perfectly periodic solution at gain = 2
        for(double gain = 0.05; gain < 5.5; gain += 0.1) {
            System.out.println("gain = " + gain);
            logistic(gain, 0.1, 3.0);
            System.out.println();
        }
        in.close();
    }

    private static void logistic(double gain, double y, double oldAbsDy) {
        double dy = gain * y * (1.0 - y);
        double absDy = Math.abs(dy);

        if(absDy < 0.000001) {
            System.out.println("\nTerminal value = " + y);
        }
        else if(absDy > oldAbsDy && y > 0.67) {
            System.out.println("Not converging");
        }
        else {
            logistic(gain, y + dy, absDy);
        }
    }
}