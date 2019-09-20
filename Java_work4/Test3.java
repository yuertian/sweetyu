public class Test3{
    public static void main(String[] args) {
        System.out.println(sum(10));
    }

    public static int sum(int num){
        if (num == 1){
            return 1;
        } else {
            return num + sum(num - 1);
        }
    }
}