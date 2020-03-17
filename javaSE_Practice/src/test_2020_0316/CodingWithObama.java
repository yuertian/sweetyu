package test_2020_0316;

import java.util.Scanner;

public class CodingWithObama {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            String c = sc.next();
            int row = N /2;
            if (N % 2 != 0) {
                //四舍五入
                row = N / 2 + 1;
            }
            for (int i = 0; i < row; i++) {
                for (int j =0; j < N; j++) {
                    if (i== 0 || i == row - 1 || j == 0 || j == N -1) {
                        System.out.print(c);
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}
