package bankersAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Init {
    public static int reType = 0;
    public static int proCount = 0;
    public static int[] Ava = new int[reType];
    public static int[][] All = new int[proCount][reType];
    public static int[][] Need = new int[proCount][reType];
    public static int[] R = new int[reType];

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

    public static int getReType() {
        return reType;
    }

    public static int getProCount() {
        return proCount;
    }

    public static void init(){

        Scanner input = new Scanner(System.in);

        System.out.print("请输入资源的种类数：");
        reType = input.nextInt();//资源的种类数

        System.out.print("请输入所有的进程数：");
        proCount = input.nextInt();//所有进程数

//        String Available = new int[reType];//各类资源可用数
        System.out.print("请输入所有可利用的资源数Available[]=");
        for (int i = 0; i < reType; i++) {
            Ava[i] = input.nextInt();
        }
        System.out.println(Arrays.toString(Ava));

        System.out.println("请输入所有进程的资源分配情况：");
        for (int i = 0; i < proCount; i++) {
            System.out.print("进程" + i + "=");
            for (int j = 0; j < reType; j++) {
                All[i][j] =input.nextInt();
            }
        }

        System.out.println("请输入所有进程还需分配的资源情况：");
        for (int i = 0; i < proCount; i++) {
            System.out.print("进程" + i + "=");
            for (int j = 0; j < reType; j++) {
                Need[i][j] =input.nextInt();
            }
        }
    }

    //各类资源总数
    public static void resourceSum(){

        for (int r = 0; r < reType; r++) {
            for (int p = 0; p < proCount; p++)
            R[r] = Ava[p] + All[p][r] + Need[p][r];
        }
    }

}
