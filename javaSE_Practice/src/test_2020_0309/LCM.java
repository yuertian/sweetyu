package test_2020_0309;

import java.util.Scanner;

public class LCM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println((a * b) / gcd(a,b));
        }
    }

    public static int gcd (int a, int b) {
        if (b == 0){
            return a;
        }
        return gcd(b,a%b);
    }
}
