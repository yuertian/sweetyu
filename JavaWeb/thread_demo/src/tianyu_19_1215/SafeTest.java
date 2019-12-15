package tianyu_19_1215;

public class SafeTest {
    private  static int COUNT;


    public static void main(String[] args) {
        Object o = new Object();
        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 20; j++) {
                        synchronized (this) {
                            COUNT++;
                        }
//                        increment;
                    }
                }
            }).start();
        }
    }
}
