package test_2020_0313;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SingleDigits {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        char[] chars = N.toCharArray();

        /**
         * list***有10个item表示0-9，每个item的值表示数字的个数
         */
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(0);//初始化每个item都是0
        }
        for (int i = 0; i < chars.length; i++) {
            // 每遇到一个数字，就把值+1
            list.set(chars[i]-'0',list.get(chars[i]-'0')+1);
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)>0){
                System.out.println(i+":"+list.get(i));
            }
        }
    }
}
