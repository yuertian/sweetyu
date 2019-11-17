package tianyu.demo;

class Exchange {
    private int num1;
    private int num2;

    public Exchange(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public void exchangeNum() {
        int tmp = num1;
        num1 = num2;
        num2 = tmp;
    }

    public void showNum() {
        System.out.println("num1 = " + num1 + ", num2 = " + num2);
    }


}

public class Test2 {
    public static void main(String[] args) {
        Exchange exchange = new Exchange(3,4);
        System.out.println("交换前：");
        exchange.showNum();
        exchange.exchangeNum();
        System.out.println("交换后：");
        exchange.showNum();
    }
}
