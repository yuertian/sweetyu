package bankersAlgorithm;

import javax.xml.bind.SchemaOutputResolver;
import java.util.Scanner;

public class Bank {

    //Pp进程请求k个资源，Request[p][r]
    private static int[][] Request = new int[Main.proCount][Main.reType];
    private static int[][] Max = Init.Max;
    public static void bank(int[] Ava, int[][] All,
                            int[][] Need) throws InterruptedException {
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.print("请输入需要请求资源的进程：");
            int p = input.nextInt();

            //p进程要申请的资源
            Request = requestInput(p, Main.reType);

            while (true) {
                //判断申请量是否不大于需求量
                for (int i = 0; i < Main.reType; i++) {
                    if (Request[p][i] > Need[p][i]) {
                        //申请量大于该进程的需求量，不符合
                        System.out.print("申请量不符合要求，请重新输入：");
                        Request = requestInput(p, Main.reType);
                        continue;
                    }
                }//循环结束，都符合要求

                //判断申请量是否不大于系统可利用的资源量
                int count = 0;
                for (int i = 0; i < Main.reType; i++) {
                    if (Request[p][i] > Ava[i]) {
                        System.out.println("申请失败，请重新申请资源：");
                        Request = requestInput(p, Main.reType);
                        break;
                    }
                    count++;
                }//循环结束，都符合要求
                if (count == Main.reType) {
                    break;
                }
            }//循环结束，申请的资源满足条件
            // 将系统资源试分配给该p进程，并更新资源分配信息
            for (int i = 0; i < Main.reType; i++) {
                Ava[i] = Ava[i] - Request[p][i];//Available[]系统剩余可分配的资源
                All[p][i] = All[p][i] + Request[p][i];//进程当前已分配的资源情况
                Need[p][i] = Need[p][i] - Request[p][i];//进程剩余需求资源情况
            }
            //进行安全性检查，检查资源分配后，进程是否还处于安全状态
            boolean isSafe = SafeTest.safe(Ava, All, Need);
            if (isSafe == true) {
                System.out.println("P" + p + "资源分配成功！");
                System.out.println("当前资源分配情况：");
                ShowTest.showBank(All, Need, Ava);
                //如果Request = Need，资源回收
                int count = judgeRequest(p, Request, Need);//判断Request是否等于Need
                if (count == Main.reType) {
                    //资源回收
                    resourceRevocvery(p, Request, Max, Ava, All, Need);
                    System.out.println(p + "进程资源已回收");
                }
                ShowTest.showInit(Ava, Max,All,Need);
                boolean change = Change();//选择是否继续
                if (change == true){
                    continue;
                } else {
                    System.out.println("退出成功！");
                    break;
                }
            }
            //如果不安全，分配作废
            if (isSafe == false) {
                System.out.println("P" + p + "资源分配失败！");
                //撤销分配
                 for (int i = 0; i < Main.reType; i++) {
                     Ava[i] = Ava[i] + Request[p][i];//Available[]系统剩余可分配的资源
                     All[p][i] = All[p][i] + Request[p][i];//进程当前已分配的资源情况
                     Need[p][i] = Need[p][i] + Request[p][i];//进程剩余需求资源情况
                 }
                boolean change =Change();//选择是否继续
                if (change == true){
                    continue;
                } else {
                    System.out.println("退出成功！");
                    break;
                }
            }
        }
    }

    //输入p进程要申请的资源
    public static int[][] requestInput(int p, int r) {
        Scanner input = new Scanner(System.in);
        int[][] R = new int[Main.proCount][Main.reType];
        System.out.print("P" + p + "请求的资源为：");
        for (int i = 0; i < r; i++) {
            //p 为请求资源的进程
            R[p][i] = input.nextInt();
        }
        return R;
    }

    //判断Request是否等于Need
    public static int judgeRequest(int p, int[][] Request, int[][] Need) {
        int count = 0;
        for (int i = 0; i < Main.reType; i++) {
            if (Request[p][i] == Need[p][i]) {
                count++;
            }
        }
        if (count == Main.reType) {
            return count;
        }
        return 0;
    }

    //资源回收
    public static void resourceRevocvery(int p, int[][] Request, int[][]Max,
                                         int[] Ava, int[][] All, int[][] Need) {
        for (int i = 0; i < Main.reType; i++) {
            Ava[i] = Ava[i] + All[p][i] + Request[p][i];
            All[p][i] = All[p][i] + Request[p][i];
            Need[p][i] = 0;
            Max[p][i] = All[p][i];
        }
    }

    //选择是否继续提出申请
    public static boolean Change() {
        System.out.println("是否继续提出申请?（yes/no）");
        Scanner inputChange = new Scanner(System.in);
        String change = inputChange.next();
        if (change.equals("no")) {
            return false;
        }
        return true;
    }

}
