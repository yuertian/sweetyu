package day04_2020_0113;

class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0 ; i < n; i++) {
            nums1[m] = nums2[i];
            m++;
        }
        sort(nums1);
    }
    public static void sort(int[] nums) {
        for (int cur = nums.length - 1; cur >= 0; cur--) {
            for (int bound = 0; bound < nums.length - 1; bound++) {
                if (nums[bound] > nums[bound + 1]) {
                    int tmp = nums[bound + 1];
                    nums[bound + 1] = nums[bound];
                    nums[bound] = tmp;
                }
            }
        }
    }
}

