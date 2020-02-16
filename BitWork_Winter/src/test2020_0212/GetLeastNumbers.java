package test2020_0212;

import java.util.ArrayList;

public class GetLeastNumbers {
    public static void main(String[] args) {
    }
    public  static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList list = new  ArrayList(k);
        for (int bound = 1; bound < input.length; bound++) {
            int tmp = input[bound];
            int cur = bound - 1;
            for (cur = bound - 1;cur >= 0;cur--) {
                if (input[cur] > tmp) {
                    input[cur + 1] = input[cur];
                } else {
                    break;
                }
                input[cur + 1] = tmp;
            }
        }
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }
}
