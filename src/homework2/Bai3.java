package BTVN_BUOI2;

import java.util.*;

class Bai3 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int month = reader.nextInt();
        int year = reader.nextInt();
        reader.close();
        int day;

        if (month == 4 || month == 6 || month == 9 || month == 11) {
            day = 30;
        }
        else if (month == 2) {
            if  ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                day = 29;
            }
            else {
                day = 28;
            }
        }
        else {
            day = 31;
        }

        System.out.printf("Thang %d nam %d co %d ngay",month, year, day);
    }
}