package test_2020_0311;

import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            System.out.println(getResult(n));
        }
    }

    public static int getResult(int N)
    {
        int i=0,flag1=0,flag2=0;
        for(;;i++)
        {//寻找输入值N处于哪两个fibo数之间
            flag2=Fib(i);
            if(flag2>N)
                break;
            flag1=flag2;
        }
        return N-flag1>flag2-N?flag2-N:N-flag1;//输出结果
    }

    public static int Fib(int number)//递归斐波那契
    {
        if(number==0 || number == 1)
            return number;
        else
            return Fib(number-1)+Fib(number-2);
    }
}
