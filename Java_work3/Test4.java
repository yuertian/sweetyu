public class Test4{
    public static void main(String[] args) {
        int num = 15;//0000 1111
        int ret = numReturnOne(num);
        System.out.println(ret);
    }
    public static int numReturnOne(int num){
        int count = 0;
        for (int i = 0; i < 32; i++){
            if ((num & 1) == 1){
                count++;
            }
            num>>= 1;
        }
        return count;
    }
}