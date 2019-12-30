package bankersAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Init {
    public static int[][] Max = new int[Main.proCount][Main.reType];
//    public static boolean[] finishState = new boolean[Main.proCount];

    public static void init(int[] Ava, int[][] All, int[][] Need){

        Scanner input = new Scanner(System.in);

        System.out.print("请输入所有可利用的各类资源数Available = ");
        for (int i = 0; i < Main.reType; i++) {
            Ava[i] = input.nextInt();
        }

        System.out.println("请输入所有进程的资源分配情况Allocation:");
        for (int i = 0; i < Main.proCount; i++) {
            System.out.print("Process" + i + " = ");
            for (int j = 0; j < Main.reType; j++) {
                All[i][j] = input.nextInt();
            }
        }

        System.out.println("请输入所有进程还需分配的资源情况：");
        for (int i = 0; i < Main.proCount; i++) {
            System.out.print("Need" + i + " = ");
            for (int j = 0; j < Main.reType; j++) {
                Need[i][j] =input.nextInt();
            }
        }
    }


    //各个进程对各类资源的最大需求数
    public static int[][] Max(int[][] All, int[][] Need) {
        for (int i = 0; i < Main.proCount; i++) {
            for (int j = 0; j < Main.reType; j++) {
                Max[i][j] = All[i][j] + Need[i][j];
            }
        }
        return Max;
    }

//    public static boolean[] finishState(int p) {
//        for (int i = 0; i < p; i++) {
//            finishState[i] = false;
//        }
//        return finishState;
//    }


}
