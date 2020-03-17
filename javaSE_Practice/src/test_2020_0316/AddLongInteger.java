package test_2020_0316;

import java.util.Scanner;

public class AddLongInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String addend = sc.nextLine();
            String augend = sc.nextLine();
            String outPut = AddLongInteger(addend, augend);
            System.out.println(outPut);
        }
    }

    public static String AddLongInteger(String addend, String augend) {
        int lenA = addend.length();
        int lenB = augend.length();
        int lenS = Math.max(lenA, lenB);
        char[] A = addend.toCharArray();
        char[] B = augend.toCharArray();

        int[] arrA = new int[lenS];
        int[] arrB = new int[lenS];
        int[] arrS = new int[lenS + 1];

        for (int i = 0; i < lenA; i++) {
            arrA[i] = addend.charAt(lenA - 1 - i) - '0';
        }

        for (int i = 0; i < lenB; i++) {
            arrB[i] = augend.charAt(lenB - 1 - i) - '0';
        }

        for (int i = 0; i < lenS; i++) {
            int sum = arrS[i] + arrA[i] + arrB[i];
            int flag = sum /10;
            arrS[i]  = sum % 10;
            arrS[i+1] += flag;
        }
        String ret = "";
        for (int i = arrS[lenS] == 0?1:0; i < lenS + 1; i++) {
            ret += arrS[lenS - i];
        }
        return ret;
    }
}
