package day04_2020_0114;

public class IsLongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        char[] c1 = name.toCharArray();
        char[] c2 = typed.toCharArray();
        char[] newChar = new char[26];
        for (int i = 0; i < c2.length; i++) {
            newChar[c2[i] - 97] += 1;
        }
        for (int i = 0; i < c1.length; i++) {
            newChar[c1[i] - 97] -= 1;
            if (newChar[c1[i] - 97] < 0) {
                return false;
            }
        }
        return true;
    }
}
