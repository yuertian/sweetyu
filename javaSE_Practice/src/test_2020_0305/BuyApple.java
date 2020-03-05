package test_2020_0305;

import java.util.Scanner;

public class BuyApple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            System.out.println(count(n));
        }
    }

    public static int count(int n) {
        if (n % 2 == 1 || n < 6 || n == 10) {
            return -1;
        }
        if (n % 8 == 0) {//回溯0次
            return n/8;
        }
        return n / 8 + 1;
    }
}
