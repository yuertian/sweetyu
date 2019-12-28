package Bank;

import java.util.Scanner;

public class Main {


    public static int reType = 0;
    public static int proCount = 0;

    public static int getReType() {
        return reType;
    }

    public static int getProCount() {
        return proCount;
    }
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("请输入资源的种类数reType = ");
        reType = input.nextInt();//资源的种类数

        System.out.print("请输入所有的进程数proCount = ");
        proCount = input.nextInt();//所有进程数


    }
}
