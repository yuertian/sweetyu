package tianyu_19_1215;

public class InterruptTest {

    public static void explain() {
        //标志位IS_INTERRUPTED = false;
        Thread  t = new Thread();

        //interrupt();
        //1.IS_INTERRUPTED = true;
        //2.如果线程处于调用wait()/join()/sleep()造成阻塞状态，
        //就直接跑出interruptedException异常
        //3.抛出异常后，IS_INTERRUPTED = false；

        boolean interrupted = Thread.interrupted();
        //IS_INTERRUPTED = true;  如果线程处于调用
        //wait()/join()/sleep()
        t.interrupt();
        //return IS_INTERRUPTED;
        t.isInterrupted();
    }

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
