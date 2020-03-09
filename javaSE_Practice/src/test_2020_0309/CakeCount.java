package test_2020_0309;

import java.util.Scanner;

public class CakeCount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            System.out.println(cakeCount(row, col));
        }
    }

    public static int cakeCount(int row, int col) {
        int evenICount = (col / 4) * 2 + (col % 4 < 2 ? col % 4 : 2);
        int oddICount = ((col - 2) / 4) * 2 + ((col - 2) % 4 < 2 ? (col - 2) % 4 : 2);
        int ans = row / 4 * (evenICount + oddICount) * 2;
        if(row % 4 > 0) ans += evenICount;
        if(row % 4 > 1) ans += evenICount;
        if(row % 4 > 2) ans += oddICount;
        return ans;
    }
}
