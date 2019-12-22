package tianyu_19_1215;

public class ABC {
    //线程等待操作
    public static void main(String[] args) {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("A");
            }
        });

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    a.join();
                    System.out.println("B");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread c = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    b.join();
                    System.out.println("C");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        c.start();
        b.start();
        a.start();
    }

}
