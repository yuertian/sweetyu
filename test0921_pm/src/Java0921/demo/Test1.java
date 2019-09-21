package Java0921.demo;

import java.util.Arrays;

public class Test1 {
    public static void main(String args[]) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr));
        reverse(arr);
        System.out.println("after reverse: " );
        System.out.println(Arrays.toString(arr));
    }

    public static void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
}
