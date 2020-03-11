package test_2020_0310;

import java.util.Arrays;
import java.util.Scanner;

public class FindTopK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            String[] str = sc.nextLine().split(" ");
            int[] array = new int[str.length - 1];
            for (int i = 0; i < array.length; i++) {
                array[i] = Integer.parseInt(str[i]);
            }
            Arrays.sort(array);
            int k = Integer.parseInt(str[str.length - 1]);
            for (int i = 0; i < k; i++) {
                System.out.print(array[i]);
                if (i < k -1) {
                    System.out.print(" ");
                }
            }
        }
    }
}
