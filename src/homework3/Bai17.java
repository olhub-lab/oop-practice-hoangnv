package BTVN_BUOI3;

import java.util.Scanner;

public class Bai17 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int k = input.nextInt();
    int[] arr = new int[k];
    int[] count = new int[1001];

    for (int i = 0; i < k; i++) {
      arr[i] = input.nextInt();
      count[arr[i]]++;
    }
    for (int i = 0; i < k ; i++) {
      if (count[arr[i]] > 0) {
        System.out.print(arr[i] + " ");

        count[arr[i]] = 0;
      }
    }
    input.close();
  }
}
