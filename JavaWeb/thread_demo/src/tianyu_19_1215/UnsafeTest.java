package tianyu_19_1215;

public class UnsafeTest {
    private static int count;
    //1.初始化一个变量值 = 0；
    //2.启动20个线程，每个线程对这个值++，执行10000次
    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 20; j++) {

                    }
                }
            }).start();
            //>1 使用debug的方式启动
            while (Thread.activeCount() > 1) {

            }
        }
    }
}
