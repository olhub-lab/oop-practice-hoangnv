package BTVN_BUOI2;

import java.util.*;

public class Bai6 {

    public static int LCM(int a, int b) {
        int limit = a * b;
        int max = Math.max(a,b);
        
        for (int i = max; i <= limit; i += max) {
            if (i % a == 0 && i % b == 0) {
                return i;
            }
        }
        return limit;
    }
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int a = reader.nextInt();
        int b = reader.nextInt();
        reader.close();

        System.out.println(LCM(a, b));
        
    }
}