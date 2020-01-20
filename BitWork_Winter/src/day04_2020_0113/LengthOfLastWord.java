package day04_2020_0113;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == "") {
            return 0;
        }
        char[] c = s.toCharArray();
        int end = c.length - 1;
        int count = 0;
        for (int i = end; i >= 0; i--) {
            if (c[i] != ' ') {
                count++;
            }
            if (count != 0 && c[i] == ' ') {
                break;
            }
        }
        return count;
    }
}
