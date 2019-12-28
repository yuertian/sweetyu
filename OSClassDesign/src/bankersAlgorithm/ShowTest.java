package bankersAlgorithm;

import java.util.Arrays;

public class ShowTest {
    //打印出所有可用资源

//    private static boolean[] Finish = Init.finishState();

    public static void showInit(int[] Ava, int[][] Max, int[][] All, int[][] Need) {
        System.out.print("当前系统各类资源剩余");
        System.out.println("Available = " + Arrays.toString(Ava));
        System.out.println("当前系统资源情况：");
        System.out.println("PID\t\t\tMax\t\t\tAllocation\t\t\tNeed");
        for (int i = 0; i < Main.proCount; i++) {
            System.out.println("P" + i + "\t\t" + Arrays.toString(Max[i]) + "\t\t" +
                    Arrays.toString(All[i]) + "\t\t" + Arrays.toString(Need[i]));
        }
    }

    public static void showSafe(int p, int index, int[] safeSequence, int[] Work, int[][] All,
                                int[][] Need, int[][]Sum, boolean[] Finish) {
        if (index == 0) {
            System.out.println("————————————————————-———————————————————");
            System.out.println("|  PID  |    Work     |     Need     | Allocatiion |Work+Allocation| Finish |");
            System.out.println("|———————————————————————————————————————|");
        }
        System.out.println("|  P" + safeSequence[index] + "   |  " + Arrays.toString(Work)+ "  |   " +
                Arrays.toString(Need[p]) + "  |  " + Arrays.toString(All[p]) + "  |   " +
                Arrays.toString(Sum[p]) + "   |  " + Finish[p] + "  |");
        if (index == Main.proCount - 1) {
            System.out.println("|———————————————————————————————————————|");
        }
    }

    public static void showBank(int[][] All, int[][] Need, int[] Ava) {
        System.out.print("当前系统各类资源剩余");
        System.out.println("Available = " + Arrays.toString(Ava));
        System.out.println("当前系统资源情况：");
        System.out.println("————————————————————-———————————");
        for (int i = 0; i < Main.proCount; i++) {
            System.out.println("|  P" + i + "   | "
                    + Arrays.toString(All[i]) + " | " + Arrays.toString(Need[i]) + " |");
        }
        System.out.println("———————————————————————————————");
    }
}

