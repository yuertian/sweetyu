package day07_2020_0116;

public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        int left = 0;
        int right = 0;
        while (i < j) {
            while((i < j) && left <= right) {
                left += nums[i];
                i++;
                if ((j - i == 1) && (left == right)) {
                    return i;
                }
            }
            while((i < j) && right < left) {
                right += nums[j];
                j--;
                if ((j - i == 1) && (left == right)) {
                    return j;
                }
            }
        }
        return -1;
    }
}
