public class Test4{
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] newArr = arrays.copyOf(arr);
        System.out.println("newArr" + arrays.String(newArr));
    }
}