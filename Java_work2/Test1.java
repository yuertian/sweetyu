//import java.until.Scanner;

public class Test1{
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // System.out.println("请输入年龄：");
        // int age = scanner.nextInt();
        // System.out.println("age = " + age);
        int age = 23;
        System.out.println("请输入年龄：");
        if (age <= 18) {
            System.out.println("少年");
        }
        if ((age >= 19) && (age <= 28)) {
            System.out.println("qingnian");
        }
        if ((age >= 29) && (age <= 55)){
            System.out.println("中年");
        }
        if (age >= 56){
            System.out.println("老年");
        }
    }
}