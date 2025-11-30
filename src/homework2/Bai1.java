package BTVN_BUOI2;

import java.util.*;

class Bai1 {
    
    public static boolean checkPrime(int a) {
        if (a < 2) return false;
        for (int i = 2 ; i < Math.round(Math.sqrt(a) + 1); i++) {
            if (a % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        
        int a = reader.nextInt();
        reader.close();
        if (a % 2 ==0) {
            System.out.println("So chan");
            if (checkPrime(a)) {
                System.out.println("So nguyen to");
            }
            else {
                System.out.println("Khong phai so nguyen to");
            }
        }
        else {
            System.out.println("So le");
            if (checkPrime(a)) {
                System.out.println("So nguyen to");
            }
            else {
                System.out.println("Khong phai so nguyen to");
            }
        }
        
    }
}