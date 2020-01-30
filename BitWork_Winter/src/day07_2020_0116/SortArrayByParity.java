package day07_2020_0116;

public class SortArrayByParity {
    public static int[] sortArrayByParity(int[] A) {
        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            while ((left < right) && (A[left] % 2 == 0 || A[left] == 0)) {
                left++;
            }
            while ((left < right) && (A[right] % 2 == 1)) {
                right--;
            }
            int tmp = A[left];
            A[left] = A[right];
            A[right] = tmp;
            left++;
            right--;
        }
        return A;
    }

    public static void main(String[] args) {
        int[] a = {0,1};
        int[] b = sortArrayByParity(a);
        for (int i = 0; i < b.length; i++) {
            System.out.print(b[i] + " ");
        }

    }
}
