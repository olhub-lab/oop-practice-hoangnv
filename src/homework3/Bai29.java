package BTVN_BUOI3;

import java.util.Scanner;

public class Bai29 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();

    long[][] arr = new long[n][m];
    for(int i = 0; i < n; i++) {
      long sum1 = 0;
      for(int j = 0; j < m; j++) {
        arr[i][j] = sc.nextInt();

      }
    }

  }
}
