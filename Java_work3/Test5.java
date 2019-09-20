import java.util.Scanner;

public class Test5{
    public static void main(String[] args) {
        int num = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("please enter a number: ");
        num = scanner.nextInt();
        System.out.println("num的偶数位二进制序列：");
        numReturnOdd(num);
        System.out.println("num的奇数位二进制序列：");
        numReturnEven(num);
    }

    public static void numReturnOdd(int num) {
        for (int i = 30; i >= 0; i-= 2){
            int tmp = num >> i;
            System.out.print((tmp & 1) + " ");
        }
        System.out.println();
    }

    public static void numReturnEven(int num) {
        for (int i = 31; i >= 0; i-= 2){
            int tmp = num >> i;
            System.out.print((tmp & 1) + " ");
        }
        System.out.println();
    }
}



    