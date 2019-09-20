import java.util.Scanner;

public class Test2{
    public static void main(String[] args) {
        int n = 0;
        String a = "A";
        String b = "B";
        String c = "C";
        System.out.print("请输入汉诺塔层数：");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        System.out.println("汉诺塔的移动步骤：");
        hanoiTower(n,a,b,c);
    }

    public static void hanoiTower(int n, String a, String b, String c) {
        if (n == 1) {
            System.out.println(a + "-->" + c);//只有一层的时候，直接从A移到C
        } else {
            hanoiTower(n - 1, a, c, b); //把A上的n-1个盘子通过C移到A
            System.out.println(a + "-->" + c);  //把A上剩下的最后一个盘子移到C
            hanoiTower(n -1, b, a, c);  //把B上的n-1个盘子通过A移到C
        }
    }
}