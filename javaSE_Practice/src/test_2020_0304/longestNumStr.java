package test_2020_0304;

import java.util.Scanner;

public class longestNumStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str = sc.nextLine();
            int max = 0;
            int count = 0;
            int end = 0;
            for(int i=0;i<str.length();i++){
                if(str.charAt(i)>='0' && str.charAt(i)<='9'){
                    count++;
                    if(max<count){
                        max= count;
                        end = i;
                    }
                }else{
                    count = 0;
                }
            }
            System.out.println(str.substring(end-max+1,end+1));
        }
//        int start = 0;
//        int end = 0;
//        int index = 0;
//        int subStart = 0;
//        int subEnd = 0;
////        while (sc.hasNextLine()) {
////            String str = sc.nextLine();
////            char[] c = str.toCharArray();
////            while (index < c.length) {
//                int tmpStart = start;
//                int tmpEnd = end;
//                while (index < c.length && c[index] < 48 || c[index] > 57) {
//                    index++;
//                }
//                start = index;
//                end = start;
//                while (end < c.length - 1 && c[end] + 1 == c[end + 1] ) {
//                    if (c[end] < 48 || c[end] > 57) {
//                        break;
//                    }
//                    end++;
//                }
////                System.out.println(str.substring(start, end + 1));
//                subStart = (end - start > tmpEnd - tmpStart ) ? start : tmpStart;
//                subEnd = (end - start > tmpEnd - tmpStart ) ? end : tmpEnd;
//                index = end + 1;
//            }
//            System.out.println(str.substring(subStart, subEnd + 1));
//        }
    }
}
