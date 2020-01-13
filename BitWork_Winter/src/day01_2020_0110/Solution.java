package day01_2020_0110;

class Solution1 {
    public String toLowerCase(String str) {
        if (str == null) {
            return str;
        }
        char[] c = str.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] >= 'A' && c[i] <= 'Z') {
                c[i]+= 32;
            }
        }
        String str1 = new String(c);
        return str1;
    }
}


