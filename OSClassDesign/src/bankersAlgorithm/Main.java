package bankersAlgorithm;

import java.util.Scanner;

public class Main {
    public static int reType = 0;//初始化资源种类数
    public static int proCount = 0;//初始化进程数

    public static void main(String[] args) throws InterruptedException {

        Scanner input = new Scanner(System.in);

        System.out.print("请输入资源的种类数reType = ");
        reType = input.nextInt();//资源的种类数

        System.out.print("请输入所有的进程数proCount = ");
        proCount = input.nextInt();//所有进程数

        int[] Ava = new int[reType];//系统和当前可用的资源数
        int[][] All = new int[proCount][reType];//所有进程已经分配的资源情况
        int[][] Need = new int[proCount][reType];//.....还需要分配的

        //初始化资源分配情况
        Init.init(Ava, All, Need);
        int[][] Max = Init.Max(All, Need);
        ShowTest.showInit(Ava, Max, All, Need);

        System.out.print("对当前进行安全性检查");//输出当前资源分布情况
        Thread t = new Thread();
        t.sleep(1000);
        System.out.print(".");
        t.sleep(1000);
        System.out.print(".");
        t.sleep(1000);
        System.out.print(".");
        t.sleep(1000);
        System.out.println();             //检查时出现的...
        boolean isSafe = SafeTest.safe(Ava, All, Need);
        if (isSafe == true) {
            System.out.println("进程可以提出资源申请");
            Bank.bank(Ava, All, Need);
        }
    }
}
