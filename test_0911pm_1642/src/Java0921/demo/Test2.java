package Java0921.demo;

public class Test2 {
    public static void main(String args[]) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        System.out.println("to String:");
        String newArr = toString(arr);
        System.out.println(newArr);
    }

    public static String toString(int[] arr) {
        String ret = "[";
        for (int i = 0; i < arr.length; i++) {
            ret += arr[i];
            if (i != arr.length - 1) {
                ret += ", ";
            }
        }
        ret += "]";
        return ret;
    }
}
