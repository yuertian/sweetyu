package bankersAlgorithm;

import java.util.Arrays;
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

        //初始化资源分配情况
        Init.init();

        Bank.bank();
//        System.out.println();
        //判断当前状态是否安全
        //通过银行家算法判断
        //如果安全，则给出安全序列


        //如果进程p2提出资源请求，判断能否给予满足
        //继续通过银行家算法进行判断
    }
}
