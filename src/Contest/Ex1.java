package Contest;

import java.util.Arrays;
import java.util.Scanner;

public class Ex1 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    int testcase = 1;
    while (T-- > 0) {
      int n = sc.nextInt();
      int[] check = new int[100005];
      int[] arr = new int[n];

      Arrays.sort(arr);

      for (int i = 0; i < n; i++) {
        arr[i] = sc.nextInt();
        check[arr[i]]++;
      }

      System.out.printf("Test %d:\n", testcase);
      testcase++;
      for (int i = 0; i < n; i++) {
        if (check[arr[i]] > 0) {
          System.out.printf("%d %d\n", arr[i], check[arr[i]]);
          check[arr[i]] = 0;
        }
      }
    }
    sc.close();
  }
}
