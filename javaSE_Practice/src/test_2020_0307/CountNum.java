package test_2020_0307;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CountNum {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (input.hasNextInt()) {
            list.add(input.nextInt());
        }
        Collections.sort(list);
        System.out.println(list.get(list.size() / 2 - 1));
    }
}
