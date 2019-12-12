package tianyu_19_1212;

public class CreateThreadTest {
    public static void main(String args[]) {
        MyThread thread = new MyThread("我的线程");
        thread.start();//启动的子线程和主线程是同时执行的

       //while (true){}
    }
}

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }
    @Override
    public void run() {
        System.out.println(currentThread().getName());
        while (true){}
    }
}
