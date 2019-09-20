import java.util.Random;
import java.util.Scanner;

public class Test6{
    public static void main(String[] args) {
        int num = 0;
        Random r = new Random(1);
        int ran = r.nextInt(1000);
        while (num != ran) {
            System.out.print("请新入：");
            Scanner scanner = new Scanner(System.in);
            num = scanner.nextInt();
            if (num > ran) {
                System.out.println("大了~");
            }
            if (num < ran) {
                System.out.println("小了~");
            }
        }
        System.out.println("找到了！");
    }
}