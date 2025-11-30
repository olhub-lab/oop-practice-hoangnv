package BTVN_BUOI3;

import java.util.Scanner;

/*
Nhập số nguyên n (1 ≤ n ≤ 9). In ra bảng cửu chương của n từ 1 đến 10. Mỗi phép nhân in trên một dòng dạng "n x i = ketqua".

Input Format

3

Constraints

1 ≤ n ≤ 9

Output Format

3 x 1 = 3

3 x 2 = 6

3 x 3 = 9

3 x 4 = 12

3 x 5 = 15

3 x 6 = 18

3 x 7 = 21

3 x 8 = 24

3 x 9 = 27

3 x 10 = 30
*/
public class Bai16 {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    int n = reader.nextInt();
    for (int i = 1; i<=10; i++) {
      int value = n * i;
      System.out.printf("%d x %d = %d",n,i,value);
      System.out.println();
    }
  }
}
