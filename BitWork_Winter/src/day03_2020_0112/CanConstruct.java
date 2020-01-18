package day03_2020_0112;

import java.util.HashMap;
import java.util.Map;

public class CanConstruct {
//    public boolean canConstruct(String ransomNote, String magazine) {
//        Map<Character, Integer> map = new HashMap<>();
//        char[] ran = ransomNote.toCharArray();
//        char[] mag = magazine.toCharArray();
//        int p = 0;
//        for (int i = 0; i < mag.length; i++) {
//            if (map.containsKey(mag[i]) == true) {
//                p++;
//            }
//            map.put(mag[i], p);
//        }
//        for (int i = 0; i < ran.length; i++) {
//            map.remove(ran[i],-1);
//            if (map.ran[i] < 0) {
//                return false;
//            }
//        }
//        return true;
//    }
public boolean canConstruct(String ransomNote, String magazine) {
    if (ransomNote.length() > magazine.length()) {
        return false;
    }
    char[] caps = new char[26];
    char[] mag = magazine.toCharArray();
    char[] ran = ransomNote.toCharArray();
    for (int i = 0; i < mag.length; i++) {
        caps[mag[i] - 'a'] += 1;
    }
    for (int i = 0; i < ran.length; i++) {
        caps[ran[i] - 'a'] -= 1;
        if (caps[ran[i] - 'a'] < 0) {
            return false;
        }
    }
    return true;
}
}
