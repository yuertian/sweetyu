package day01_2020_0111;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                size--;
            }
        }
        return size;
    }
}
