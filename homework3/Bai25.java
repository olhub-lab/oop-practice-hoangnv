package BTVN_BUOI3;

import java.util.Scanner;

public class Bai25 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int n = input.nextInt();
    long[] arr = new long[n];
    arr[0] = input.nextLong();
    long max = arr[0];
    for (int i = 1; i < n; i++) {
      arr[i] = input.nextLong();
      if(arr[i] > max){
        max = arr[i];
      }
    }
    long max2 = 0;
    boolean flag = false;
    for (int i = 0; i < n-1; i++) {
      if(arr[i] < max){
        if (!flag) {
          flag = true;
          max2 = arr[i];
        }
        else {
          if (arr[i] > max2) {
            max2 = arr[i];
          }
        }

      }
    }
    if (!flag) {
      System.out.println("Khong ton tai");
    }
    else {
      System.out.println(max2);
    }
  }
}
