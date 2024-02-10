import java.util.Scanner;

public class recursivePalindrome {

    public static void main(String[] args) {
        System.out.print("Enter a message: ");
        Scanner input = new Scanner(System.in);
        
        String msg = input.nextLine();
        if(isPalindrome(msg)) {
            System.out.println(msg + " is a palindrome.");
        } else if(!isPalindrome(msg)) {
            System.out.println(msg + " is not a palindrome.");
        }
        input.close();
        
    }


    //getReverse is a function that returns the reverse of a given string recursively
    private static String getReverse(String msg, String newMSG) {
        int index;

        if(!msg.isEmpty()) {
            index =  msg.length() - 1;
            newMSG += msg.charAt(index);
            return getReverse(msg.substring(0, index), newMSG);
        } else {
            return newMSG;
        }
    }

    //isPalindrome is a function that checks if a string is a palindrome or not, if it is a palindrome it returns true, if it is not a palindrome it returns false
    private static boolean isPalindrome(String msg) {
        String newMSG = "";
        if(msg.equals(getReverse(msg, newMSG))) {
            return true;
        }else {
            return false;
        }
 }
}