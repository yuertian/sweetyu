package tianyu_19_1215;

public class UnsafeTest {
    private static int COUNT = 0 ;
    //1.初始化一个变量值 = 0；
    //2.启动20个线程，每个线程对这个值++，执行10000次
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 10000; j++) {
                        COUNT++;
                    }
                }
            }).start();
        }
        //>1 使用debug的方式启动
        while (Thread.activeCount() > 1) {
            //线程让步，从运行态转变为就绪态
            //活跃线程数大于1的时候就保持就绪状态，
            //直到活跃线程数为1的时候再继续向下执行
            Thread.yield();
        }
        System.out.println(COUNT);
    }
}
