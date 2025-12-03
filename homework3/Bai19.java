package BTVN_BUOI3;

import java.util.Scanner;

public class Bai19 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int n = input.nextInt();
    int[] arr = new int[n];

    int sum = 0;

    for (int i = 0; i < n; i++) {
      arr[i] = input.nextInt();
      if (arr[i] % 2 == 0) {
        sum += arr[i];
      }
    }

    System.out.println(sum);
    input.close();
  }
}
