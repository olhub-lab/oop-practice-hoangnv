package BTVN_BUOI3;

import java.util.Arrays;
import java.util.Scanner;

public class Bai12 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    int k = sc.nextInt();
    Arrays.sort(arr);

    int count = 0;
    for(int i = 0; i < n; i++) {
      if(i == 0 ||arr[i] != arr[i-1] ) {
        count++;
      }
      if(count == k) {
        System.out.println(arr[i]);
        return;
      }
    }
    System.out.println("invalid");
  }
}
