package bankersAlgorithm;

import java.util.Arrays;

//安全检查性算法
public class SafeTest {
    //工作向量，表示系统可提供给进程继续运行的各类资源数目
    public static int[][] Work = new int[Main.proCount][Main.reType];
    //进程状态，初值为0，表示进程还处于未完成状态
    private static int[] safeSequence = new int[Main.proCount];

    //在进程中查找符合条件的进程
    //1.finishState = false;
    //2. Need < work;
    public static boolean safe( int r, int p, int[] Ava, int[][] All, int[][] Need) {
        //在安全性检查算法开始执行时，work = Available
        for (int i = 0; i < r; i++) {
            Work[0][i] = Ava[i];
        }
        int count = 0;//记录已完成的进程

        while (true) {
            boolean flag = false;//判断进程状态是否更新
            //循环判断每一个进程是否满足条件
            for (int i = 0; i < p; i++) {
                int count2 = 0;
                flag = false;
                //如果满足条件，更新Work,更新进程状态
                if (Main.Finish[i] == false) {
                    for (int j = 0; j < r; j++){
                        //只要有一个不满足就退出循环
                        if (Need[i][j] > Work[i][j]){
                            break;
                        }
                        count2++;//记录满足条件的资源数
                    }//循环结束，如果count2 = r,说明Need <= Work
                    if (count2 == r) {
                        for (int j = 0; j < r; j++) {
                            Work[i][j] = All[i][j] + Work[i][j];
                        }
                        Main.Finish[i] = true;//状态置为已完成
                        count++;//记录已完成的进程数
                        flag = true;
                        safeSequence[i] = i;
                    }
                }
            }
            //安全
            if (count == p) {
                System.out.println("当前状态安全");
               System.out.println("安全序列为：" + Arrays.toString(safeSequence));
                return true;
            }
            if (flag == false) {
                System.out.println("当前状态不安全");
                return false;
            }
        }
    }

//    public static boolean isSafe() {
//        boolean s = safe(int );
//        if (s == true){
//            return true;
//        }else {
//            return false;
//        }
//    }



//    public static int[] workSum() {
//        int[] sum = new int[r];
//        for (int i = 0; i < p; i++) {
//            sum[i] = 0;
//            for (int j = 0; j < r; j++) {
//                sum[i] += Work[j];
//            }
//        }
//        return sum;
//    }
//
//    public static int[] needSum() {
//        int[] sum = new int[r];
//        for (int i = 0; i < p; i++) {
//            sum[i] = 0;
//            for (int j = 0; j < r; j++) {
//                sum[i] += Need[i][j];
//            }
//        }
//        return sum;
//    }
}
