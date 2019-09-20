public class Test{
    public static void main(String[] args){
        int num1 = 9;
        int num2 = 3;
        int num3 = 0;

        int max = numMax(num1, num2, num3);
        int min = numMin(num1, num2, num3);

        System.out.println("max=" + max);
        System.out.println("min=" + min);
    }

    static int numMax(int x, int y, int z){
        int max = (x > y) ? x : y;
        if (max > z){
            return max;
        } else{
            return z;
        }
    }

    static int numMin(int x, int y, int z){
        int min = (x < y) ? x : y;
        if (min < z){
            return min;
        }else{
            return z;
        }
    }
}