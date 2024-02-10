//What is wrong with this recursive method?

// Answer: The following recursive method does not have an ending condition, therefore it causes an infinite loop which is not desired. 
//This can be solved by adding a condition to the end of the recursive method, stating that the recursive method should return the sum of the numbers from 1 to n 
// while n is less than a certain value ( in this case 5). The imporoved method can be seen below. 

public class chapter_11_2 {
    public static void main(String[] args) {
        System.out.println(sum(1));
        
    }

    // public static long sum(long n) {
    //     return n + sum(n + 1);
    // }

    public static long sum(long n) {
        int numToAdd = 10;
        if (n < numToAdd) {
            return n + sum(n + 1);
        }
        else {
            return n;
        }
    }
}
