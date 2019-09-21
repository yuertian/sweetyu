package Java0921.demo;

public class Test4 {
    public static void main(String args[]) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int num = 2;
        int ret = halfFind(arr, 2);
        System.out.println(ret);
    }

    public static int halfFind(int[] arr, int n) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int mid = (left + right) / 2;
            if (n < arr[mid]) {
                right = mid - 1;
            } else if (n > arr[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
