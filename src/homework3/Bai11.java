package BTVN_BUOI3;


/*
Cho hai mảng số nguyên. Nhiệm vụ của bạn là:

In ra tất cả các phần tử thuộc hợp của hai mảng trên một dòng (mỗi số chỉ in ra 1 lần). In ra tất cả các phần tử thuộc giao của hai mảng trên dòng thứ hai(mỗi số chỉ in ra 1 lần). Nếu không có phần tử chung nào giữa hai mảng, in ra "NO" trên dòng thứ hai.

Định dạng đầu vào: Dòng thứ nhất chứa một số nguyên n (số lượng phần tử của mảng thứ nhất). Dòng thứ hai chứa n số nguyên (các phần tử của mảng thứ nhất). Dòng thứ ba chứa một số nguyên m (số lượng phần tử của mảng thứ hai). Dòng thứ tư chứa m số nguyên (các phần tử của mảng thứ hai).

Định dạng đầu ra: Dòng thứ nhất in ra tất cả các phần tử thuộc hợp của hai mảng theo thứ tự tăng dần, mỗi số cách nhau một dấu cách. Dòng thứ hai in ra tất cả các phần tử thuộc giao của hai mảng theo thứ tự tăng dần, mỗi số cách nhau một dấu cách. Nếu không có phần tử chung, in "NO".

Input Format

5

1 2 3 4 5

5

3 4 5 6 7

Constraints

1≤n,m≤10^3 Giá trị của các phần tử trong mảng nằm trong khoảng -10^5 đến 10^5

Output Format

1 2 3 4 5 6 7

3 4 5
*/
import java.util.Scanner;

public class Bai11 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int[] check = new int[1000005];
    int OFFSET = 100000;

    int n = sc.nextInt();
    for (int i = 0; i < n; i++) {
      int value = sc.nextInt();
      check[value + OFFSET] = 1;
    }

    int m = sc.nextInt();
    for (int i = 0; i < m; i++) {
      int value = sc.nextInt();
      int index = value + OFFSET;

      if (check[index] == 1) {
        check[index] = 2;
      }
      else if (check[index] == 0) {
        check[index] = 3;
      }
    }
    for (int i = 0; i < check.length; i++) {
      if (check[i] > 0) {
        System.out.print((i-OFFSET) + " ");
      }
    }
    System.out.println();

    boolean exist = false;
    for (int i = 0; i < check.length; i++) {
      if (check[i] == 2) {
        System.out.print((i-OFFSET) + " ");
        exist = true;
      }
    }
    if (!exist) {
      System.out.print("NO");
    }
  }
}