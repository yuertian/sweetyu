package test2020_0212;
import java.util.Scanner;
class Test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {
            String str = in.nextLine();
            char[] c = str.toCharArray();//30-39
            int cur = 0;
            int tmp = 0;
            while (cur < c.length - 1) {
                int count = 0;
                while ((cur < c.length - 1) && (c[cur] < '0' || c[cur] > '9')) {
                    cur++;
                }
                while ((cur < c.length - 1) && ((c[cur] + 1) - 30) == c[cur + 1] - 30) {
                    count++;
                    cur++;
                }
                if (count > tmp) {
                    tmp = count;
                }
            }
            System.out.println(tmp);
//        }
    }
}
