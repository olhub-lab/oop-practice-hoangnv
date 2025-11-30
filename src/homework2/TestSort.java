package BTVN_BUOI2;

import java.util.Scanner;

public class TestSort {
  public static int binarySearch(int[] a, int target) {
    int low = 0;
    int high = a.length - 1;

    while (low <= high) {
      int middle = (low + high) / 2;
      int value = a[middle];

      if (target < value) {
        high = middle - 1;
      }
      else if (target > value) {
        low = middle + 1;
      }
      else return middle;
    }
    return -1;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] arr = new int[100];

    for (int i = 1; i < arr.length; i++) {
      arr[i] = i;
    }

    int result = binarySearch(arr, n);

    if (result == -1) {
      System.out.println("-1");
    }
    else {
      System.out.println(result);
    }
  }
}