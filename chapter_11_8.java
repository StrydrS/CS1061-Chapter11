//What's wrong with this method?
// Answer: This method works if x is greater than or equal to 0.5, where it simply returns x. 
// In the case where x is less than 0.5, the method returns a random number and adds it to the sum(x).
// However, sum(x) is not known by the program. For example, if x is 0.4, it would execute the else statement,
// and return sum(0.4) + Math.random(). But again, sum(0.4) is not known by the program, so it will continue to execute th
// the else statement indefinitely. 

// a possible solution to fix this is found in the sum2() method below. 

public class chapter_11_8 {
    public static void main(String[] args) {
        //System.out.print(sum(0.4));
        System.out.println(sum2(0.4, 0));
    }

    @SuppressWarnings("unused")
    private static double sum(double x) {
        if( x >= 0.5) {
            return x;
        }
        else {
            return(sum(x) + Math.random());
        }
    }

    // this is my improved version of the sum() method.
    private static double sum2(double x, int count) {
        if (x >= 0.5 || count >= 20) {
            return x;
        } else {
            return sum2(x + Math.random(), count + 1);
        }
    }
}