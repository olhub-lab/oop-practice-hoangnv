package BTVN_BUOI3;

import java.util.Scanner;
import java.math.BigDecimal;

public class Bai30 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long T = sc.nextLong();
    while (T-- > 0){
      BigDecimal a = new BigDecimal(sc.next());
      BigDecimal b = new BigDecimal(sc.next());
      BigDecimal c = new BigDecimal(sc.next());

      if (a.add(b).compareTo(c) > 0 && b.add(c).compareTo(a) > 0 && a.add(c).compareTo(b) > 0) {
        System.out.print("YES");
      } else {
        System.out.print("NO");
      }
      System.out.println();
    }
  }
}
