package BTVN_BUOI2;

import java.util.Scanner;

public class MergeSort {
  public int[] merge(int[] a1, int[] a2) {
    int n = a1.length + a2.length;
    int[] result = new int[n];

    int i = 0; int i1 = 0; int i2 = -0;

    while(i < n) {
      if (i1 < a1.length && i2 < a2.length) {
        if (a1[i1] <= a2[i2]) {
          result[i] =  a1[i1];
          i++; i1++;
        }
        else {
          result[i] =  a2[i2];
          i2++; i++;
        }
      } else {
        if (i1 < a1.length) {
          result[i] =  a1[i1];
          i++; i1++;
        } else {
          result[i] =  a2[i2];
          i2++; i++;
        }
      }
    }
    return result;
  }

  public int[] mergeSort(int[] arr, int L, int R) {
    if (L > R) {
      return new int[0];
    }
    if (L == R) {
      int[] singleElement = {arr[L]};
      return singleElement;
    }

    //chia
    int mid = (L + R) / 2;
    int[] a1 = mergeSort(arr, L, mid);
    int[] a2 = mergeSort(arr, mid+1, R);

    //Trộn vào
    return merge(a1, a2);
  }

  public int[] sortArray(int[] nums) {
    return mergeSort(nums, 0, nums.length - 1);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    MergeSort ms = new MergeSort();
    int[] sortedArray = ms.sortArray(arr);
    for (int i : sortedArray) {
      System.out.print(i + " ");
    }
  }
}
