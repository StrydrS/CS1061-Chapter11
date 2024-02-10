//Modify the previous exercise’s program so that it uses iteration instead of
//recursion. Do not use an array.

import java.util.Scanner;

public class chapter_11_5 {
    
    private static String recurseButNo(Scanner scan, int strlen) {

        // String filled with even words, odd words

        String item = "";
        @SuppressWarnings("unused")
        String item1 = "";

        //counter for even words

        int counter = 2;

        //for loop to fill the string with

        for(int i = 0; i < strlen; i++) {

            //if the next word is even,

                if (scan.hasNext() & counter % 2 == 0) {
                    item += scan.next() + " ";
                    counter++;
                } //if the next word is odd,
                
                else if(scan.hasNext() & counter % 2 == 1) {
                    item1 += scan.next() + " ";
                    counter++;
                }
        }

        //return even string 
      return item;
        //return odd string
      //return item1;
    }
    
    
    public static void main(String[] args) {
        String string = "Jack and Jill went up the Hill" + " to fetch a pail of water";
        int strlen = string.length();
        Scanner scan = new Scanner(string);

        string = recurseButNo(scan, strlen);
        System.out.println(string);
        
        scan.close();
    
    }    

}