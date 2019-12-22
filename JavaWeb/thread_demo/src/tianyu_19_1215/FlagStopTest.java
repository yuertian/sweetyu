package tianyu_19_1215;

public class FlagStopTest {

    private static boolean IS_INTERRUPTED = false;

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (!IS_INTERRUPTED) {
                    System.out.println(Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        IS_INTERRUPTED = true;
    }
}
