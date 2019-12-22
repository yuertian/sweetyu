package tianyu_19_1215;

import sun.awt.windows.ThemeReader;

import static java.lang.Thread.*;

public class InterruptTest {
    public static void explain() {
        Thread t = new Thread();//IS_INTERRUPTED = false;
        //return IS_INTERRUPTED; IS_INTERRUPTED = false;
        boolean interrupted = interrupted();//当前线程被中断
        //1.IS_INTERRUPTED = true;
        //2.如果线程处于调用wait()/join()/sleep()方法造成阻塞状态
        //就抛出InterruptedException异常
        t.currentThread().interrupt();
        //return IS_INTERRUPTED;
        t.currentThread().isInterrupted();
    }


    //中断以后，执行异常处理逻辑，然后再继续执行
    public static void ignoreInterrupt() throws InterruptedException {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                //--> main()没有修改为true，中断后继续执行
                while (!currentThread().isInterrupted()) {
                    //--> main()有修改为true
                    System.out.println(currentThread().getName());
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
        sleep(5000);
        t.interrupt();
    }

    //中断以后，立即退出
    public static void interruptQuit() throws InterruptedException {
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {//中断后立即停止执行
                    while (!currentThread().isInterrupted()) {
                        System.out.println(currentThread().getName());
                        sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
        sleep(5000);
        t2.interrupt();
    }


    public static void main(String[] args) throws InterruptedException {
        ignoreInterrupt();
        interruptQuit();
    }
}
