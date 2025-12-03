package homework3;

import java.util.Scanner;

public class Bai14 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int n = input.nextInt();
    int[] mark = new int[n];
    int[] lesson = new int[n];
    for (int i = 0; i < n; i++) {
      lesson[i] = input.nextInt();
    }
    for (int i = 0; i < n; i++) {
      mark[lesson[i]] = input.nextInt();
    }

  }
}
