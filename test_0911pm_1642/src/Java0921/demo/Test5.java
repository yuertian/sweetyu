package Java0921.demo;

import java.util.Arrays;

public class Test5 {
    public static void main(String args[]) {
        int[] arr = {3, 8, 4, 7, 2, 9, 6, 5, 10, 1};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("after sort:");
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        for (left = 0; left < arr.length - 1; left++) {
            for (right = arr.length - 1; right > left; right--){
                if (arr[right] < arr[right - 1]) {
                    int tmp = arr[right];
                    arr[right] = arr[right - 1];
                    arr[right - 1] = tmp;
                }
            }
        }
    }
}
