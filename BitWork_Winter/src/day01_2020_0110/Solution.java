package day01_2020_0110;

public class Solution {
    public String toLowerCase(String str) {
        int len = str.length();
        for (int i = 0; i < len; i++) {
            if (str[i] >= 'A' && str[i] <= 'Z') {
                str[i] = str[i] + 32;
            }
        }
        return str;
    }
}
