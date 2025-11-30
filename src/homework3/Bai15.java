package BTVN_BUOI3;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Bai15 {

  public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);

    int n = reader.nextInt();
    long result = 1;
    for (int i = n; i > 0; i--) {
      result *= i;
    }
    System.out.println(result);
    reader.close();
  }
}