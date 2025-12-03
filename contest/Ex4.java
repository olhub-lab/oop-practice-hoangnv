package contest;

import java.util.Scanner;

public class Ex4 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long T = sc.nextLong();
    while (T-- > 0) {
      long a = sc.nextLong();
      long b = sc.nextLong();
      long c = sc.nextLong();

      if (a + b > c && a + c > b && b + c > a) {
        System.out.println("YES");
      }
      else  {
        System.out.println("NO");
      }
    }
  }
}
