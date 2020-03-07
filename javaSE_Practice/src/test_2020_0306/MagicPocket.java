package test_2020_0306;

import java.util.Scanner;

public class MagicPocket {
    public static int n;
    public static int[] array = new int[20];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            System.out.println(count(0, 40));
        }
    }

    public static int count(int i, int sum) {
        if (sum == 0) {
            return 1;
        }
        if (i == n || sum < 0) {
            return 0;
        }
        return count(i + 1, sum - array[i]) + count(i + 1, sum);
    }
}
