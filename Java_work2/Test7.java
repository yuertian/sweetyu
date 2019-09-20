public class Test7 {
    public static void main(String[] args) {
        double sum=0;
        for(int i=1;i<=100;i++){
           sum+=Math.pow(-1, i-1)/(double)i;
        }
        System.out.println(sum);
    }
}