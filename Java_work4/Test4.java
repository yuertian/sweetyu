public class Test4{
    public static void main(String[] args) {
        int num = 1234;
        printNum(num);
    }

    public static void printNum(int num){
        if (num > 9){
            printNum(num / 10);
        }
        System.out.print(num % 10 + " ");
    }
}