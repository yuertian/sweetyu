import java.util.Scanner;

public class Test3{
    public static void main(String[] args) {
        System.out.print("请输入台阶数：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int ret = frogDanceSteps(n);
        System.out.println("共有" + ret + "种跳法");
    }

    public static int frogDanceSteps(int n){
        if (n == 1){
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            return frogDanceSteps(n - 1) + frogDanceSteps(n - 2);
        }
    }
}