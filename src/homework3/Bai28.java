package BTVN_BUOI3;

import java.util.Scanner;

public class Bai28 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] mark =  new int[n+1];
    int[] arr = new int[n];

    for (int i = 1; i < n-1; i++) {
      arr[i] = sc.nextInt();
      mark[arr[i]] = 1;
    }

    for(int i = 1; i < n; i++) {
      if (mark[i] == 0) {
        System.out.print(i + " ");
      }
    }
  }
}
