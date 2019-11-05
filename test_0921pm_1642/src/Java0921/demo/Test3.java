package Java0921.demo;

import java.util.Arrays;

public class Test3 {
    public static void main(String args[]) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] newArr = copyArr(arr, 4);
        System.out.println("new = " + Arrays.toString(newArr));
    }

    public static int[] copyArr(int[] arr, int n) {
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = arr[i];
        }
        return ret;
    }
}
