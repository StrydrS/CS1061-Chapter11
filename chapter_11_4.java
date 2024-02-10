import java.util.Scanner;
// Modify the previous exercise’s Recurse program so that it uses Page 526
//tail recursion. Minimize code changes. You should be able to do this with
//exactly the same number and sequence of statements and with only internal alterations
//to one line in the main method and three lines in the recurse method.

public class chapter_11_4 {
    
    public static String recurse(Scanner scan, String accumulated) {
    if (scan.hasNext()) {
        String item = scan.next() + " ";
        if(scan.hasNext()) {
            scan.next();
        }
        return recurse(scan, accumulated + item);
    } else {
        return accumulated;
    }
}

    
    
    public static void main(String[] args) {
        String string = "Jack and Jill went up the Hill" + " to fetch a pail of water";
        Scanner scan = new Scanner(string);

        string = recurse(scan, "");
        System.out.println(string);
    
    
    }    
}
