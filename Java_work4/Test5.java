public class Test5{
    public static void main(String[] args) {
        int num = 12345;
        System.out.println(addNum(num));
    }
    
    public static int addNum(int num){
        if (num < 10){
            return num;
        } else {
            return (num % 10) + addNum(num /10);
        }
    }
}