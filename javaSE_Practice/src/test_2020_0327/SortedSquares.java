package day06_2020_0115;

class SortedSquares {
    public int[] sortedSquares(int[] A) {
        for (int i = 0; i < A.length; i++) {
            A[i] = A[i] * A[i];
        }
        //排序
//        quickSort(A, 0, A.length - 1);
        for (int cur = A.length - 1; cur >= 0; cur--) {
            for (int bound = 0; bound < A.length - 1; bound++) {
                if (A[bound] > A[bound + 1]) {
                    int tmp = A[bound + 1];
                    A[bound + 1] = A[bound];
                    A[bound] = tmp;
                }
            }
        }
        return A;
    }
//    public static void quickSort(int[] A, int left, int right) {
//        if (left >= right) {
//            return;
//        }
//
//        int baseIndex = quickSortHelper(A, left, right);
//        quickSort(A, 0, baseIndex - 1);
//        quickSort(A, baseIndex + 1, right);
//    }
//    public static int quickSortHelper(int[] A, int left, int right) {
//        int baseIndex = right;
//        int baseValue = A[baseIndex];
//        while (left < right) {
//            while (left < right && A[left] <= baseValue) {
//                left++;
//            }
//            while (left < right && A[right] >= baseValue) {
//                right--;
//            }
//            swap(A, left, right);
//        }//循环结束，基准值等于A[left]
//        swap(A, left, baseIndex);
//        //基准值前面的都比基准值小，后面的都比基准值大
//        return left;
//    }
//    public static void swap(int[] A, int left, int right) {
//        int tmp = A[left];
//        A[left] = A[right];
//        A[right] = tmp;
//    }
}