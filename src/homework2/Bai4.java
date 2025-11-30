package BTVN_BUOI2;

import java.util.*;

class Bai4 {
    public static int sumArray(int n) {
        int total = 0;
        for(int i = 1; i <= n ;i++) {
            if (i % 2 != 0) total += i;
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int n = reader.nextInt();
        reader.close();

        System.out.println(sumArray(n));
    }
}