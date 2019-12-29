package tianyu_19_1220;

import javax.swing.plaf.nimbus.State;

public class ThreadStateTest {

    public static void test1() {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        System.out.println("new:" + t.getState());
        t.start();
        System.out.println("start:" + t.getState());
    }

    public static void main(String[] args) {
        for (Thread.State state : Thread.State.values()) {
            System.out.println(state);
        }
        test1();
    }
}
