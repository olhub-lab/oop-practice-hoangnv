package BTVN_BUOI3;

import java.util.Arrays;
import java.util.Scanner;

public class Bai13 {
  public static boolean upToADigit(int[] a, int n) {
    int length = a.length;
    for (int i = length - 1; i > -1 ; i--) {
      if (a[i] < 9) {
        a[i] += 1;
        return false;
      }
      a[i] = 0;
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = sc.nextInt();
    }
    if (upToADigit(a, n)) {
      System.out.print("1,");
    }
    for (int i = 0; i < n; i++) {
      System.out.print(a[i]);
      if (i < n-1) {
        System.out.print(",");
      }
    }
  }
}
