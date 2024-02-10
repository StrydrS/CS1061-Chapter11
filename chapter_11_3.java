import java.util.Scanner;

public class chapter_11_3 {
    
    public static String recurse(Scanner scan) {
        String item = "";
        if (scan.hasNext()) {
            item = scan.next() + " ";
        }
        if(item.equals("")) {
            return item;
        }
        else { 
            if(scan.hasNext()) {
                scan.next();
            }

            // essentially, this method is recursively reading tokens from the Scanner, 
            //appending them to the item String, and then calling itself recursively until there 
            //are no more tokens left in the Scanner. At that point, it starts returning the accumulated String from the recursive calls.
            // returns every other word of the string


            return item + recurse(scan);
        }
    }
    
    public static void main(String[] args) {
        String string = "Jack and Jill went up the Hill" + " to fetch a pail of water";
        Scanner scan = new Scanner(string);

        string = recurse(scan);
        System.out.println(string);
    
    
    }    
}
