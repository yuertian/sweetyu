
public class Test1 {
    //方法重载
	public static void main(String[] args) {
		//此时将根据参数的类型和个数的不同执行不同的方法体
		System.out.println(add(10, 20));
		System.out.println(add(30, 40, 50));
		System.out.println(add(1.1, 2.1));
	}
	public static int add(int x, int y) {
		return x + y;
	}
	//此时方法名称相同，参数的个数不同
	public static int add(int x, int y, int z) {
		return x + y + z;
	}
	public static double add(double x, double y) {
		return x + y;
	}
}