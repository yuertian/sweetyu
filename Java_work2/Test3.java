public class Test3{
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++){
            if (i == 1){
                System.out.println("yes!");
            }
            for (int j =1; j<i; j++){
                if(i % j != 0){
                    j++;
                }
                if (j == i){
                    System.out.println(i);
                }
            }
        }
    }
}