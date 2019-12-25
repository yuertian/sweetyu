package bankersAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Init {
    public static int resourse = Main.reType;
    public static int process = Main.proCount;
//    public static int[][] All = new int[process][resourse];
//    public static int[][] Need = new int[process][resourse];
    public static int[][] Max = new int[process][resourse];
    public static boolean[] finishState = new boolean[Main.proCount];

    public static void init(int[] Ava, int[][] All, int[][] Need){

        Scanner input = new Scanner(System.in);



        System.out.print("请输入所有可利用的各类资源数Available[] = ");
        for (int i = 0; i < resourse; i++) {
            Ava[i] = input.nextInt();
        }
        System.out.println(Arrays.toString(Ava));

        System.out.println("请输入所有进程的资源分配情况Allocation[][] =  ");
        for (int i = 0; i < process; i++) {
            System.out.print("Process" + i + " = ");
            for (int j = 0; j < resourse; j++) {
                All[i][j] = input.nextInt();
            }
        }

        System.out.println("请输入所有进程还需分配的资源情况：");
        for (int i = 0; i < process; i++) {
            System.out.print("Need" + i + " = ");
            for (int j = 0; j < resourse; j++) {
                Need[i][j] =input.nextInt();
            }
        }

    }

    //各类资源总数
//    public static int[] resourceSum(){
//        for (int r = 0; r < resourse; r++) {
//            for (int p = 0; p < process; p++){
//                R[r] = Ava[p] + All[p][r] + Need[p][r];
//            }
//        }
//        return R;
//    }

    //各个进程对各类资源的最大需求数
    public static int[][] Max(int[][] All, int[][] Need) {
        for (int p = 0; p < process; p++) {
            for (int r = 0; r < resourse; r++) {
                Max[p][r] = All[p][r] + Need[p][r];
            }
        }
        return Max;
    }

    public static boolean[] finishState() {
        for (int i = 0; i < process; i++) {
            finishState[i] = false;
        }
        return finishState;
    }


}
