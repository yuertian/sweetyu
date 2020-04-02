package day03_2020_0112;

public class IsPalindrome {
    public boolean isPalindrome(int x) {
        char[] ch = isPalindromeHelper(x).toCharArray();
        int mid = ch.length / 2;
        int left = 0;
        int right = ch.length - 1;
        for (int i = 0; i <= mid; i++) {
            if (ch[left] != ch[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static String isPalindromeHelper(int x) {
        String str = "";
        if (x / 10 != 0) {
            isPalindromeHelper(x / 10);
        }
        return str + x;
    }
}
