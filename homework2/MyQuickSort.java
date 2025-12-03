package homework2;

import java.util.Scanner;

public class MyQuickSort {
  public static void quickSort(int[] arr, int l, int r) {
    if (l >= r) return;

    int i = l;
    int j = r;
    int pivot = arr[(l + r) / 2];
    while (i <= j) {
      while (arr[i] < pivot) i++;
      while (arr[j] > pivot) j--;
      if (i <= j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
      }
    }
    if (l < j) quickSort(arr,l, j);
    if (i < r) quickSort(arr,i,r);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();

    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }

    quickSort(arr, 0, n - 1);

    for (int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }
    sc.close();
  }
}