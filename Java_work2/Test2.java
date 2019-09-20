public class Test2{
    public static void main(String[] args) {
        int num = 10;
        if (num == 1){
            System.out.println("yes!");
        }
        int j = 2;
        for (int i = 1; i <= num; i++){
            if(num % j != 0){
                j++;
            }
        }
            if (num % j == 0){
                System.out.println("no!");
            }
            if (j == num){
                System.out.println("yes!");
            }
        
    }
}