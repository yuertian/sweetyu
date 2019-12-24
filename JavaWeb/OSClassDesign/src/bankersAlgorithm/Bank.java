package bankersAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Bank {

    private static int resource = Main.reType;
    private static int process = Main.proCount;
    private static int[] Ava = Init.getAva();
    private static int[][] All = Init.getAll();
    private static int[][] Need = Init.getNeed();
    //Pp进程请求k个资源，Request[p][r]
    private static int[][] Request = new int[process][resource];

    public static void bank() {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入需要请求资源的进程：");
        int p = input.nextInt();

        //p进程要申请的资源
        Request = requestInput(p);

        while (true) {
            //判断申请量是否不大于需求量
            for (int i = 0; i < resource; i++) {
                if (Request[p][i] > Need[p][i]) {
                    //申请量大于该进程的需求量，不符合
                    System.out.print("申请量不符合要求，请重新输入：");
                    Request = requestInput(p);
                    continue;
                }
            }//循环结束，都符合要求

            //判断申请量是否不大于系统可利用的资源量
            int count = 0;
            for (int i = 0; i < resource; i++) {
                if (Request[p][i] > Ava[i]) {
                    System.out.println("申请失败，请重新申请资源：");
                    Request = requestInput(p);
                    break;
                }
                count++;
            }//循环结束，都符合要求
            if (count == resource) {
                break;
            }
        }//循环结束，申请的资源满足条件

        // 将系统资源分配给该p进程，并更新资源分配信息
        processAllocation(p);

        //进行安全性检查，检查资源分配后，进程是否还处于安全状态
        SafeTest.safe();
        //如果不安全，分配作废
    }

    //输入p进程要申请的资源
    public static int[][] requestInput(int p) {
        Scanner input = new Scanner(System.in);
        int[][] R = new int[process][resource];
        System.out.print(p + "请求的资源为：");
        for (int i = 0; i < resource; i++) {
            //p 为请求资源的进程
            R[p][i] = input.nextInt();
        }
        return R;
//        System.out.println(Arrays.toString(Request));
    }

    //资源分配
    public static void processAllocation(int p) {
        for (int i = 0; i < resource; i++) {
            Ava[i] = Ava[i] - Request[p][i];//Available[]系统剩余可分配的资源
            All[p][i] = All[p][i] + Request[p][i];//进程当前已分配的资源情况
            Need[p][i] = Need[p][i] - Request[p][i];//进程剩余需求资源情况
        }
    }

    //撤销分配
    public static void allocationRevocation(int p) {
        for (int i = 0; i < resource; i++) {
            Ava[i] = Ava[i] - Request[p][i];//Available[]系统剩余可分配的资源
            All[p][i] = All[p][i] + Request[p][i];//进程当前已分配的资源情况
            Need[p][i] = Need[p][i] - Request[p][i];//进程剩余需求资源情况
        }
    }

//    public  static int requestSum(int[][] arr, int p, int r) {
//        int sum = 0;
//        for (int i = 0; i < r; i++) {
//            sum += arr[p][i];
//        }
//        return sum;
//    }
//
//    public static int proNeedSum(int[][] arr, int p, int r) {
//        int sum = 0;
//        for (int i = 0; i < r; i++) {
//            sum += arr[p][i];
//        }
//        return sum;
//    }

}
