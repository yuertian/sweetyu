package test_2020_0302;


import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String A = sc.nextLine();
            String B = sc.nextLine();
            int count = 0;

//             if ((judge(A) == true && B == null) || (A == null && judge(B) == true)) {
//               System.out.println(1);
//               return;
//            }
            if (judge(B + A) == true) {
                count++;
            }
            if (judge(A + B) == true) {
                count++;
            }
            for (int i = 1; i < A.length(); i++) {
                String left = A.substring(0, i);
                String right = A.substring(i);
                String merge = left + B + right;
                if (judge(merge) == true) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
    public static boolean judge(String s) {
        char[] c = s.toCharArray();
        int left = 0;
        int right = c.length - 1;
        while (left <= right) {
            if (c[left] != c[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
