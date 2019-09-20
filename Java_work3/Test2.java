public class Test2{
    public static void main(String[] args) {
        for (int i = 0; i <= 999; i++){
            int a = i / 100;
            int b = (i /10) % 10;
            int c = i % 10;
            if (i == (a*a*a)+(b*b*b)+c*c*c){
                System.out.println(i);
            }
        }
    }
}