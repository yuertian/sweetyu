package day02_2020_0111;

public class SearchInsert {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }//循环结束，没有找到
        int left = 0;
        int right = nums.length - 1;
        if (target <= nums[0]) {
            return 0;
        }
        if (target >= nums[nums.length - 1]) {
            return nums.length;
        }
        while (left <= right) {
            if (target > nums[left]) {
                left++;
            }
            if (target < nums[right]) {
                right--;
            }
        }
        return left;
    }
}
