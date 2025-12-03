package homework2;

import java.util.Scanner;

public class SquareMatrix {
  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    int n = reader.nextInt();
    int[][] a = new int[n][n];

    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        a[i][j] = reader.nextInt();
        reader.nextLine();
      }
    }
    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        System.out.print(a[i][j] + " ");
      }
      System.out.println();
    }
  }
}
