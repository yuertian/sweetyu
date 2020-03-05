package test_2020_0305;

import java.util.Scanner;

public class DeleteStr {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String pattern = "[" + s2 + "]";
            String result = s1.replaceAll(pattern, "");
            System.out.println(result);
        }
    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (sc.hasNextLine()) {
//            String s1 = sc.nextLine();
//            String s2 = sc.nextLine();
//            System.out.println(deleteStr(s1, s2));
//        }
//    }
//
//    public static String deleteStr(String s1, String s2) {
//        if (s1 == null || s1.equals(s2)) {
//            return null;
//        }
//        for (int i =0; i < s2.length(); i++) {
//            char c = s2.charAt(i);
//            int index = s1.indexOf(c);
//            if (index > -1) {
//                String[] tmp = s1.split(c);
//                s1 = "";
//                for (String x: tmp) {
//                    s1 += x;
//                }
//            }
//        }
//        return s1;
//    }
}
