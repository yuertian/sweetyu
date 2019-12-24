package bankersAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Init {
    public static int resourse = Main.reType;
    public static int process = Main.proCount;
    public static int[] Ava = new int[resourse];
    public static int[][] All = new int[process][resourse];
    public static int[][] Need = new int[process][resourse];
    public static int[] R = new int[resourse];
    public static int[] P = new int[process];
    public static int[] N = new int[process];

    public static int[] getAva() {
        return Ava;
    }

    public static int[][] getAll() {
        return All;
    }

    public static int[][] getNeed() {
        return Need;
    }

    public static int[] getR() {
        return R;
    }



    public static void init(){

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
            System.out.print("Need" + i + "=");
            for (int j = 0; j < resourse; j++) {
                Need[i][j] =input.nextInt();
            }
        }
    }

    //各类资源总数
    public static int[] resourceSum(){
        for (int r = 0; r < resourse; r++) {
            for (int p = 0; p < process; p++){
                R[r] = Ava[p] + All[p][r] + Need[p][r];
            }
        }
        return R;
    }

    //各个进程对各类资源的最大需求数
    public static int[] reNeedMax() {
        for (int p = 0; p < process; p++) {
            for (int r = 0; r < resourse; r++) {
                P[p] = All[p][r] + Need[p][r];
            }
        }
        return P;
    }

//    //各个进程的需求量之和
//    public static int[] needMax() {
//        for (int i = 0; i < process; i++) {
//            N[i] = 0;
//            for (int j = 0; j < resourse; j++) {
//                N[i]+= Need[i][j];
//            }
//        }
//        return N;
//    }

}
