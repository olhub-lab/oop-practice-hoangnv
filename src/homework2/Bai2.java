package BTVN_BUOI2;

import java.util.*;

class Bai2 {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        int height = reader.nextInt();
        int width = reader.nextInt();
        reader.close();

        for(int i = 0; i < height; i++){
            for (int j = 0 ;j < width;j++) {
                if (i == 0 || i == (height-1)|| j == 0 || j == (width-1)) {
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}