//package tianyu_19_1212;
//
//public class SleepTest {
//    public static void main(String[] args) {
//
//        Thread.sleep(5000);//作用在main线程
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    for (int i = 0; i < 10; i++) {
//                        System.out.println(i);
//                        Thread.sleep(1000);//作用在new的Tread
//                    }
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }
//}
