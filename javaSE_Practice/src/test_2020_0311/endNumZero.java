package test_2020_0311;

import java.util.Scanner;

public class endNumZero {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int ret = 0;
            for (int i = 5; i <= n; i *= 5) {
                ret += n / i;
            }
            System.out.println(ret);
        }
    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextInt()) {
//            int n = sc.nextInt();
//            int ret = factorial(n);
//            int count = 0;
//            while (ret % 10 == 0) {
//                count++;
//                ret /= 10;
//            }
//            System.out.println(count);
//        }
//    }
//
//    public static int factorial(int n) {
//        if (n <= 2) {
//            return n;
//        }
//        return n * factorial(n - 1);
//    }
}
