package homework2;

import java.util.*;

public class Bai5 {

    public static boolean setArmStrong(int numb) {
        int total = 0;
        int temp = numb;
        int digit;

        if (numb < 0) {
            return false;
        }
        while (temp > 0) {  
            digit = temp % 10;
            total += (digit * digit * digit);
            temp /= 10;
        }
        return total == numb;

    }
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = reader.nextInt();
        reader.close();

        if (setArmStrong(n)) System.out.println("Yes");
        else System.out.println("No");
        
    }
}