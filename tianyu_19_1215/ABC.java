package tianyu_19_1215;

public class ABC {
    Thread a = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("A");

        }
    });

    Thread b = new Thread(new Runnable() {
        @Override
        public void run() {
            System.out.println("B");
        }
    });

}
