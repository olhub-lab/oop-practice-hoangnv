package homework3;

import java.util.Scanner;

public class Bai31 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int T = input.nextInt();
    int count = 1;
    while (T-- > 0) {
      int n = input.nextInt();
      int[] arr = new int[n];
      int[] mark = new int[100001];
      for (int i = 0; i < n; i++) {
        arr[i] = input.nextInt();
        mark[arr[i]]++;
      }
      System.out.printf("Test %d:\n",count);
      count++;
      for (int i = 0; i < n; i++) {
        if (mark[arr[i]] > 0) {
          System.out.printf("%d %d\n",arr[i], mark[arr[i]]);
          mark[arr[i]] = 0;
        }
      }
    }
  }
}
