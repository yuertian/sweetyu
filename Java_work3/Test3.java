import java.util.Scanner;

public class Test3{
    public static void main(String[] args) {
        int Key = 123999;
        int keyIn = 0;
        int count = 0;
        while (count <= 3){
            Scanner scanner = new Scanner(System.in);
            System.out.print("请输入密码：");
            keyIn = scanner.nextInt();
            if (keyIn == Key){
                System.out.println("登录成功！");
                break;
            } 
            if (keyIn != Key){
                System.out.println("密码错误！");
                count++;
                if (count == 3) {
                    System.out.println("三次输入错误！请退出程序。");
                    break;
                }
                continue;
            }
        }   
       
    }
}