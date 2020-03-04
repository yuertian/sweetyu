package test_2020_0304;

public class Parenthesis {
    public static void main(String[] args) {
        String s = "(())()(a)";
        int n = s.length();
        System.out.println(chkParenthesis(s, n));
    }

    public static boolean chkParenthesis(String A, int n) {
        // write code here
        if (n % 2 == 1) {
            return false;
        }
        char[] c = A.toCharArray();
        int left = 0;
        for (int i = 0; i < n; i++){
            if (c[i] == '(') {
                left++;
            }
            if (c[i] == ')') {
                left--;
            }
            if (left < 0) {
                return false;
            }
        }
        if (left == 0) {
            return true;
        }
        return false;
    }
}
//if(n % 2 == 1) return false;
//        char[] c = A.toCharArray();
//        int left =0;
//        for(int i = 0; i < n; i++){
//        if(c[i]=='(') left++;
//        if(c[i]==')') left--;
//        if(left < 0) return false;
//        }
//        if( left == 0) return true;
//        return false;