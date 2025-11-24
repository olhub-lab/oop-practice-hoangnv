package Contest;

import java.util.Scanner;

public class Ex2 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[200005];
    for (int i = 0; i < n; i++) {
      arr[i] = sc.nextInt();
    }
    long sum = 0;
    for (int i = 1; i < n; i++) {
      long total = (long) arr[i] * arr[i - 1];
      sum += total;
    }
    System.out.println(sum);
  }
}
