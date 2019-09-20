import java.util.Scanner;

public class Test7{
    public static void main(String[] args) {
        int num = 0;
        System.out.print("please enter a number: ");
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        numPrint(num);//1729
    }

    public static void numPrint(int num){
        if (num > 9){
            numPrint(num /10);
        }
        System.out.println(num % 10);
    }
}