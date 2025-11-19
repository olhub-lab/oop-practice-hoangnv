package BTVN_BUOI2;

import java.util.Arrays;

public class Sort {
    public static void selectionSort(int[] arr) {
        for (int i = 0 ; i< arr.length-1; i++) {
            int min = i;
            for (int j= i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
    
    public static void bubbleSort(int[] a) {
        int temp;
        for (int i = 0; i < a.length-1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            int j = i-1;
            while (j >=0 && a[j] > temp) {
                a[j+1] = a[j];
                j--;
            }
            a[j+1] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {8, 7, 9, 2, 3 ,1, 5, 4, 6};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));

        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));

        insertionSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
