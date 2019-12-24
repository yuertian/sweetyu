package bankersAlgorithm;

//安全检查性算法
public class SafeTest {

    //工作向量，表示系统可提供给进程继续运行的各类资源数目
    //在安全性检查算法开始执行时，work = Available
    public static int[] Work = Init.getAva();
    //进程状态，初值为0，表示进程还处于未完成状态
    public static boolean[] finishState = new boolean[Main.proCount];

    private static int[][] All = Init.All;
    private static int[][] Need = Init.Need;
    private static int p = Main.proCount;
    private static int r = Main.reType;
    //在进程中查找符合条件的进程
    //1.finishState = false;
    //2. Need < work;


    public static void safe() {
//        int[] workSum = needSum();
//        int[] needSum = workSum();

        int count = 0;//记录已完成的进程数

        //将每个进程的初始状态置为0
        for (int i = 0; i < p; i++) {
            finishState[i] = false;
        }
        while (true) {
            boolean flag = false;//判断进程状态是否更新
            //循环判断每一个进程是否满足条件
            for (int i = 0; i < p; i++) {
                flag = false;
                //如果满足条件，更新Work,更新进程状态
                if (finishState[i] == false) {
                    for (int j = 0; j < r; j++){
                        //不满足条件
                        if (Need[i][j] > Work[i]){
                            break;
                        }
                    }
                    for (int j = 0; j < r; j++) {
                        Work[j] = All[i][j] + Work[j];
                        finishState[i] = false;
                        count++;
                        flag = true;
                    }
                }
            }
            if (flag == false) {
                System.out.println("当前状态不安全！");
                break;
            }
            //安全
            if (count == p) {
                System.out.println("该序列安全");
                break;
            }

        }
    }

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
