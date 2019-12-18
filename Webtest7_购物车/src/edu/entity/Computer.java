package edu.entity;

public class Computer {
    public double getAdd(double a, double b) {
        return a + b;
    }

    public double getSub(double a, double b) {
        return a - b;
    }

    public double getMul(double a, double b) {
        return a * b;
    }

    public double getDiv(double a, double b) {
//        if (b == 0) {
//            try {
//                throw new Exception("除数不能为0");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
        return a / b;
    }
}
