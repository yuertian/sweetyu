package tianyu.demo;

class Calculator {
    private int num1;
    private int num2;

    public Calculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public void addNum() {
        System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
    }

    public void subtractNum() {
        System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
    }

    public void rideNum() {
        System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
    }

    public void divideNum() {
        System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
    }
}

public class Test1 {
    public static void main(String[] args) {
        Calculator add = new Calculator(2,3 );
        Calculator subtract = new Calculator(2, 1);
        Calculator ride = new Calculator(2, 4);
        Calculator divide = new Calculator(6, 2);

        add.addNum();
        subtract.subtractNum();
        ride.rideNum();
        divide.divideNum();
    }
}
