package homework2;

import java.util.*;

public class Bai7 {
    public static int checkDivide(int numb) {
        int total = 0;
        int i = 1;
        while (i <= numb) {
            if (i % 5 == 0 || i % 3 == 0) {
                total += i;
            }
            i++;
        }
        return total;
    }
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
        int n = reader.nextInt();
        reader.close();

        System.out.println(checkDivide(n));
    }
}