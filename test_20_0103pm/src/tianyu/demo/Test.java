package tianyu.demo;

public class Test {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        try {
            System.out.println("before");
            System.out.println("arr[100]");//产生异常，就跳转到catch里面继续执行
            System.out.println("after");
        } catch (ArrayIndexOutOfBoundsException e) {
            //异常处理代码
            //打印调用栈
            e.printStackTrace();//打印出现异常的调用栈和相关信息，同时程序还能继续执行
        }//catch 的参数类型要和 try 抛出的异常相匹配，不匹配的话，catch不会生效，由JVM处理
        System.out.println("after try");
    }
}
