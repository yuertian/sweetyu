package test_2020_0311;

import java.util.Scanner;

public class numReversed {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            String str = "";
            System.out.println(reverseNum(n, str));
        }
    }

    public static String reverseNum(int n, String str) {
        if (n < 10) {
            return str + n;
        }
        return reverseNum(n / 10, str + (n % 10));
    }
}
