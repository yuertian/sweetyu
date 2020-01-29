package day06_2020_0115;

public class ReverseOnlyLetters {
    public static char[] reverseOnlyLetters(String S) {
        char[] c1 = S.toCharArray();
        char[] c2 = new char[c1.length];
        int cur = c1.length - 1;
        for (int i = 0; i < c1.length; i++) {
            if ((c1[i] < 65) || (c1[i] > 90 && c1[i] < 97) || (c1[i] > 122)) {
                c2[i] = c1[i];
            }
        }
        for (int i = 0; i < c1.length; i++) {
            if ((c1[i] > 64 && c1[i] < 91) || (c1[i] > 96 && c1[i] < 123)) {
                while (c2[cur] != 0){
                    cur--;
                }
                c2[cur] = c1[i];
            }
        }
        return c2;
    }

    public static void main(String[] args) {
        char[] c = reverseOnlyLetters("a-bC-dEf-ghIj");
        for (char x:
             c) {
            System.out.print(x);
        }
    }
}
