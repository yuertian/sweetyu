package bankersAlgorithm;

import java.util.Arrays;

//安全检查性算法
public class SafeTest {
    //工作向量，表示系统可提供给进程继续运行的各类资源数目
    public static int[] Work = new int[Main.reType];
    private static int[][] Sum = new int[Main.proCount][Main.reType];
    private static int[] safeSequence = new int[Main.proCount];
    public static boolean[] Finish = new boolean[Main.proCount];

    //在进程中查找符合条件的进程
    //1.finishState = false;
    //2. Need < work;
    public static boolean safe(int[] Ava, int[][] All, int[][] Need) {
        int count = 0;//记录已完成的进程
        int index = 0;//安全序列的下标
        for (int i = 0; i < Main.reType; i++) {
            Work[i] = Ava[i];
        }
        for (int i = 0; i < Main.proCount; i++) {
            Finish[i] = false;
        }
        while (true) {
            boolean flag = false;//判断进程状态是否更新
            //循环判断每一个进程是否满足条件
            for (int i = 0; i < Main.proCount; i++) {
                int count2 = 0;
                flag = false;
                //如果满足条件，更新Work,更新进程状态
                if (Finish[i] == false) {
                    for (int j = 0; j < Main.reType; j++){
                        //只要有一个不满足就退出循环
                        if (Need[i][j] > Work[j]){
                            break;
                        }
                        count2++;//记录满足条件的资源数
                    }//循环结束，如果count2 = r,说明Need <= Work
                    if (count2 == Main.reType) {
                        safeSequence[index] = i;//安全序列插入进程数

                        Finish[i] = true;//状态置为已完成
                        flag = true;
                        for (int j = 0; j < Main.reType; j++) {
                            Sum[i][j] = Work[j] + All[i][j];
                        }
                        //打印资源分配情况
                        ShowTest.showSafe(i, index, safeSequence, Work, All, Need, Sum, Finish);
                        for (int j = 0; j < Main.reType; j++) {
                            Work[j] = All[i][j] + Work[j];
                        }
                        index++;
                        count++;//记录已完成的进程数
                    }
                }
            }
            //安全
            if (count == Main.proCount) {
                System.out.println("当前状态安全!");
               System.out.println("安全序列为：" + Arrays.toString(safeSequence));
                return true;
            }
            if (flag == false) {
                System.out.println("当前状态不安全");
                return false;
            }
        }
    }
}
