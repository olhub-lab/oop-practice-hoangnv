package BTVN_BUOI2;

import java.util.*;

public class Bai10 {

    public static long LengthOfNumb(long numb) {
        long count = 0;
        while (numb > 0) {
            numb /= 10;
            count +=1;
        }
        return count;
    }
    
    public static long TotalOfNumb(long numb) {
        long total = 0;
        long digit;
        long temp = numb;
        while (temp > 0) {
            digit = temp % 10;
            total += digit;
            temp /= 10;
        }
        return total;
    }
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        long n = reader.nextLong();
        reader.close();
        System.out.println(LengthOfNumb(n));
        System.out.println(TotalOfNumb(n));


    }
}