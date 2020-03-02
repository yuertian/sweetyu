package test_2020_0302;


public class Finder {


    public static int findKth(int[] a, int n, int K) {
        sort(a, 0, n - 1);
        return a[K - 1];
    }

    public static void sort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int baseIndex = findBaseIndex(a, left, right);
        sort(a, left, baseIndex - 1);
        sort(a, baseIndex + 1, right);
    }

    public static int findBaseIndex(int[] a, int left, int right) {
        int baseIndex = right;
        int baseValue = a[baseIndex];
        while (left < right) {
            while (left < right && a[left] <= baseValue) {
                left++;
            }
            while (left < right && a[right] >= baseValue) {
                right--;
            }
            swap(a, left, right);
        }
        swap(a, left, baseIndex);
        return left;
    }

    public static void swap(int[] a, int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }
//    public static void main(String[] args) {
//        int[] a = {1, 3, 5, 2, 2};
//        int x = findKth(a, 5, 3);
//        System.out.println(x);
//    }
}