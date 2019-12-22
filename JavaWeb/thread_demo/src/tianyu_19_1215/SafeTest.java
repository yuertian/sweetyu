package tianyu_19_1215;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class SafeTest {
    private  static int COUNT;

    //静态同步方法
    public static synchronized void  increment() {
        COUNT++;
    }
    //同样的效果
//    public void decrement() {
//        synchronized (SafeTest.class) {
//            COUNT++;
//        }
//    }


    //实例同步方法
    public synchronized void decrement() {
        COUNT++;
    }
    //同样的效果
//    public static void decrement() {
//        synchronized(this) {
//            COUNT--;
//        }
//    }


    public static void main(String[] args) {
        Object o = new Object();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 10000; j++) {
//                    synchronized (this) {
//                        COUNT++;
//                    }
                    //不推荐使用Integer、String对象锁定
                    //原因是常量池和堆中对象的不确定性
//                    synchronized (COUNT) {
//                        COUNT++;
//                    }
                        increment();
//                        decrement();
                }
            }
        };
        for (int i = 0; i < 20; i++) {
            new Thread(r).start();
        }
        while (Thread.activeCount() > 1) {
            Thread.yield();
        }
        System.out.println(COUNT);
    }
}
