package BTVN_BUOI3;

import java.util.Scanner;

public class Bai22 {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();

    int[] mark =  new int[1001];
    int[] arr = new int[N];

    for(int i = 0; i < N; i++){
      arr[i] = sc.nextInt();
      mark[arr[i]]++;
    }
    for (int i = 0; i < N-1; i++){
      for (int j = i+1; j < N; j++){
        boolean flag = false;
        if (mark[arr[i]] > mark[arr[j]]){
          flag = true;
        }
        else if (mark[arr[i]] == mark[arr[j]]){
          if (arr[i] < arr[j]){
            flag = true;
          }
        }
        if (flag){
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
    }

    for (int i = N-1; i > -1; i--){
      System.out.print(arr[i] + " ");
    }
  }
}
