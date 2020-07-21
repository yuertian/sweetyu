package test_2020_0721;

public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        int newLength = str.length() + 2 * count; // 新字符串的长度
        int newEnd = newLength -1; // 索引新字符串的最后一个有效位置
        int oldEnd = str.length() - 1; // 索引旧字符串的最后一个有效位置
        str.setLength(newLength); // 设置新字符串的大小，防止下标越界

        while (newEnd >= 0 && oldEnd >= 0) {
            if (str.charAt(oldEnd) == ' ') {
                str.setCharAt(newEnd--, '0');
                str.setCharAt(newEnd--, '2');
                str.setCharAt(newEnd--, '%');
                oldEnd--;
            } else {
                str.setCharAt(newEnd--,str.charAt(oldEnd));
                oldEnd--;
            }
        }
        return str.toString();
    }
}
