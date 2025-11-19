import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Bai9 {
    public static boolean perfectNumber(int numb) {
        int total = 0;
        for (int i = 1; i< numb; i++) {
            if (numb % i ==0) {
                total += i;
            }
        }
        return total == numb;
    }
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
        int n = reader.nextInt();
        reader.close();

        if (perfectNumber(n)) {
            System.out.println("yes");
        }
        else {
            System.out.println("no");
        }
    }
}