package tianyu_19_1212;

public class CreateRunnableTest {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable(),"我的线程");
        t.start();
        System.out.println("main方法" + Thread.currentThread().getName());
    }

}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}