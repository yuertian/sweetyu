import java.util.Scanner;

public class Test1{
    public static void main(String[] args) {
        System.out.print("please enter a number: ");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(fib(num));
    }

    public static int fib(int n){
        if (n <= 2){
            return 1;
        } else {
            return fib(n - 1) + fib(n -2);
        }
    }
}