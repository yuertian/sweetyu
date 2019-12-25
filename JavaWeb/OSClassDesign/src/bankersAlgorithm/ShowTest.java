package bankersAlgorithm;

import java.util.Arrays;

public class ShowTest {
    //打印出所有可用资源

//    private static boolean[] Finish = Init.finishState();

    public static void showInit(int p, int[] Ava, int[][] Max, int[][] All, int[][] Need) {
        System.out.print("当前系统各类资源剩余");
        System.out.println("Available = " + Arrays.toString(Ava));
        System.out.println("当前系统资源情况：");
        System.out.println(" ———————————————————————————————");
        System.out.println("|  PID  |\t\tMax\t\t|\tAllocation\t|\t\tNeed\t\t|");
        for (int i = 0; i < p; i++) {
            System.out.println("|  P" + i + "   | " + Arrays.toString(Max[i]) + " | " +
                    Arrays.toString(All[i]) + " |\t" + Arrays.toString(Need[i]) + "\t|");
        }
        System.out.println(" ———————————————————————————————");
    }

    public static void showSafe(int p, int[][] Work, int[][] All,
                                int[][] Need, int[][]Sum, boolean[] Finish) {
    System.out.println("————————————————————-——————————————————————");
    System.out.println("|  PID  |     Work     |     Need     |  Allocatiion  | Work+Allocation | Finish |");
    System.out.println("|——————————————————————————————————————————|");
    for (int i = 0; i < p; i++) {
        System.out.println("|  P" + i + "   | "
                + Arrays.toString(Work[i]) + " | " + Arrays.toString(Need[i]) + " | " +
                Arrays.toString(All[i]) + " |" + Arrays.toString(Sum[i]) + "|  " + Finish[i] + "  |");
    }
    System.out.println("|——————————————————————————————————————————|");
    }

    public static void showBank(int p, int[][] All, int[][] Need, int[] Ava) {
        System.out.print("当前系统各类资源剩余");
        System.out.println("Available = " + Arrays.toString(Ava));
        System.out.println("当前系统资源情况：");
        System.out.println("————————————————————-———————————");
        for (int i = 0; i < p; i++) {
            System.out.println("|  P" + i + "   | "
                    + Arrays.toString(All[i]) + " | " + Arrays.toString(Need[i]) + " |");
        }
        System.out.println("———————————————————————————————");
        System.out.println("——————————-——————————————————————");
    }
}

